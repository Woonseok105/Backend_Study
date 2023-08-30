package com.example.assignment.domain.user.exception

import com.example.assignment.global.error.CustomException
import com.example.assignment.global.error.ErrorCode

object UnAuthorizedException : CustomException(
    ErrorCode.UN_AUTHORIZED
)