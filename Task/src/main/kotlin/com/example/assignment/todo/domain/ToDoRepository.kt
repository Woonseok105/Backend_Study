package com.example.assignment.todo.domain

import org.springframework.data.repository.CrudRepository

interface ToDoRepository : CrudRepository<ToDoEntity, Long> {
}