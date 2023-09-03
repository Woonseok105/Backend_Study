package com.example.assignment.domain.user.presentation.dto.response

import java.time.LocalDateTime

class TokenResponse (
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExp: LocalDateTime
)