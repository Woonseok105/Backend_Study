package com.example.assignment.global.error

import com.example.assignment.global.error.response.ErrorProperty

enum class ErrorCode (
    override val status: Int,
    override val message: String
) : ErrorProperty {

    UN_AUTHORIZED(401, "unAuthorized"),
    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),
    PASSWORD_MIS_MATCH(401, "Password Mis Match"),

    USER_NOT_FOUND(404, "User Not Found"),
    TODO_NOT_FOUND(404, "ToDo Not Found"),
    REFRESH_TOKEN_NOT_FOUND(404, "RefreshToken Not Found"),

    USER_ALREADY_EXIST(409, "User Already Exist"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}