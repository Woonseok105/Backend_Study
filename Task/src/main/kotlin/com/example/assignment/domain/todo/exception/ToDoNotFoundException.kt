package com.example.assignment.domain.todo.exception

import com.example.assignment.global.error.CustomException
import com.example.assignment.global.error.ErrorCode

object ToDoNotFoundException : CustomException(ErrorCode.TODO_NOT_FOUND)