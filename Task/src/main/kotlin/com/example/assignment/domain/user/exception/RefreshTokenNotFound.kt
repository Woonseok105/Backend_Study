package com.example.assignment.domain.user.exception

import com.example.assignment.global.error.CustomException
import com.example.assignment.global.error.ErrorCode

object RefreshTokenNotFound : CustomException(ErrorCode.REFRESH_TOKEN_NOT_FOUND)