package com.example.assignment.domain.todo.domain

import com.example.assignment.domain.user.domain.UserEntity
import org.springframework.data.repository.CrudRepository

interface ToDoRepository : CrudRepository<ToDoEntity, Long> {

    fun findAllByUserEntity(user: UserEntity): List<ToDoEntity>
}