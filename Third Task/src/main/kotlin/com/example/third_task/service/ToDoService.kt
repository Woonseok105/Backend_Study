package com.example.third_task.service

import com.example.third_task.domain.ToDoEntity
import com.example.third_task.domain.ToDoRepository
import com.example.third_task.presentation.dto.request.ToDoAddRequest
import com.example.third_task.presentation.dto.request.ToDoUpdateRequest
import com.example.third_task.presentation.dto.response.ToDoCheckResponse
import com.example.third_task.presentation.dto.response.ToDoList
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import javax.transaction.Transactional

@Service
class ToDoService(
    private val toDoRepository: ToDoRepository
) {

    fun addToDo(request: ToDoAddRequest) {
        toDoRepository.save(
            ToDoEntity(
                title = request.title,
                content = request.content
            )
        )
    }

    fun checkList(): ToDoCheckResponse {
        val todo = toDoRepository.findAll()

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
        val todo = toDoRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("해당 id를 찾을 수 없습니다.")

        todo.todoUpdate(request.title, request.content, request.isDone)
    }

    @Transactional
    fun delete(id: Long) {
        val todo = toDoRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("해당 id를 찾을 수 없습니다.")

        toDoRepository.delete(todo)
    }
}