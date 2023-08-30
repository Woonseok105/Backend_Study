package com.example.assignment.domain.user.exception

import com.example.assignment.global.error.CustomException
import com.example.assignment.global.error.ErrorCode

object UserNotFoundException : CustomException(ErrorCode.USER_NOT_FOUND)