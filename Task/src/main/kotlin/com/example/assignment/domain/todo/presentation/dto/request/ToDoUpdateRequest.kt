package com.example.assignment.domain.todo.presentation.dto.request

class ToDoUpdateRequest (
    val accountId: String,
    val password: String,
    val title: String,
    val content: String,
    val isDone: Boolean
)