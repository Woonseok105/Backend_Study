package com.example.assignment.domain.todo.service

import com.example.assignment.domain.todo.domain.ToDoEntity
import com.example.assignment.domain.todo.domain.ToDoRepository
import com.example.assignment.domain.todo.exception.ToDoNotFoundException
import com.example.assignment.domain.todo.presentation.dto.request.ToDoAddRequest
import com.example.assignment.domain.todo.presentation.dto.request.ToDoSignInRequest
import com.example.assignment.domain.todo.presentation.dto.request.ToDoUpdateRequest
import com.example.assignment.domain.todo.presentation.dto.response.ToDoCheckResponse
import com.example.assignment.domain.todo.presentation.dto.response.ToDoList
import com.example.assignment.domain.user.domain.UserRepository
import com.example.assignment.domain.user.exception.UnAuthorizedException
import com.example.assignment.domain.user.exception.UserNotFoundException
import com.example.assignment.domain.user.facade.UserFacade
import io.netty.handler.codec.base64.Base64Decoder
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.*
import javax.transaction.Transactional

@Service
class ToDoService(
    private val toDoRepository: ToDoRepository,
    private val userFacade: UserFacade,
) {

    fun addToDo(request: ToDoAddRequest) {

        val user = userFacade.getCurrentUser()

        toDoRepository.save(
            ToDoEntity(
                title = request.title,
                content = request.content,
                userEntity = user
            )
        )
    }

    fun checkList(request: ToDoSignInRequest): ToDoCheckResponse {
        val user = userFacade.getUserByAccountId(request.accountId)

        if (!user.password.equals(request.password)) {
            throw UnAuthorizedException
        }

        val todo = toDoRepository.findAllByUserEntity(user)

        return ToDoCheckResponse(
            toDoList = todo.map {
                ToDoList(
                    id = it.id,
                    title = it.title,
                    content = it.content
                )
            }
        )
    }

    @Transactional
    fun update(id: Long, request: ToDoUpdateRequest) {

        val user = userFacade.getUserByAccountId(request.accountId)

        if (!user.password.equals(request.password)) {
            throw UnAuthorizedException
        }

        val todo = toDoRepository.findByIdOrNull(id)
            ?: throw ToDoNotFoundException

        todo.todoUpdate(request.title, request.content, request.isDone)
    }

    @Transactional
    fun delete(id: Long, request: ToDoSignInRequest) {

        val user = userFacade.getUserByAccountId(request.accountId)

        if (!user.password.equals(request.password)) {
            throw UnAuthorizedException
        }

        val todo = toDoRepository.findByIdOrNull(id)
            ?: throw ToDoNotFoundException

        toDoRepository.delete(todo)
    }

    fun decode(encodedString: String): List<String> =
        String(Base64.getDecoder().decode(encodedString)).split(":")

}