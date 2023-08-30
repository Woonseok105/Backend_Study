package com.example.assignment.global.error

import com.example.assignment.global.error.response.ErrorProperty

enum class ErrorCode (
    override val status: Int,
    override val message: String
) : ErrorProperty {

    UN_AUTHORIZED(401, "unAuthorized"),

    USER_NOT_FOUND(404, "User Not Found"),
    TODO_NOT_FOUND(404, "ToDo Not Found"),

    USER_ALREADY_EXIST(409, "User Already Exist")
}