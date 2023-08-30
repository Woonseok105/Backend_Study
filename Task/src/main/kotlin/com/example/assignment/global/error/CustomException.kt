package com.example.assignment.global.error

import com.example.assignment.global.error.response.ErrorProperty

open class CustomException (
    private val errorProperty: ErrorProperty
) : RuntimeException() {

    val status: Int
        get() = errorProperty.status

    override val message: String
        get() = errorProperty.message
}