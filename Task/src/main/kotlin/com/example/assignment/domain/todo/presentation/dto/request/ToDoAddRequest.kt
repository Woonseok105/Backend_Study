package com.example.assignment.domain.todo.presentation.dto.request

import javax.validation.constraints.NotBlank

class ToDoAddRequest (

    @field:NotBlank
    val title: String,

    @field:NotBlank
    val content: String
)