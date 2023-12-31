package com.example.assignment.domain.todo.presentation.dto.response

class ToDoCheckResponse (
    val toDoList: List<ToDoList>
)

data class ToDoList (
    val id: Long,
    val title: String,
    val content: String
)