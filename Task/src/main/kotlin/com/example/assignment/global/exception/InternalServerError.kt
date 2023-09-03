package com.example.assignment.global.exception

import com.example.assignment.global.error.CustomException
import com.example.assignment.global.error.ErrorCode

object InternalServerError : CustomException(ErrorCode.INTERNAL_SERVER_ERROR)