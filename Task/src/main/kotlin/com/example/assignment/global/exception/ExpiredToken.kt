package com.example.assignment.global.exception

import com.example.assignment.global.error.CustomException
import com.example.assignment.global.error.ErrorCode

object ExpiredToken : CustomException(ErrorCode.EXPIRED_TOKEN)