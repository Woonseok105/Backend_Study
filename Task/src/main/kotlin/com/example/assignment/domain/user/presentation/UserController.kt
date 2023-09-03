package com.example.assignment.domain.user.presentation

import com.example.assignment.domain.user.presentation.dto.request.SignInRequest
import com.example.assignment.domain.user.presentation.dto.request.SignUpRequest
import com.example.assignment.domain.user.presentation.dto.response.TokenResponse
import com.example.assignment.domain.user.service.RefreshTokenService
import com.example.assignment.domain.user.service.SignInService
import com.example.assignment.domain.user.service.SignUpService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController (
    private val signUpService: SignUpService,
    private val signInService: SignInService,
    private val refreshTokenService: RefreshTokenService
) {

    @PostMapping("/register")
    fun signUp(@RequestBody request: SignUpRequest) {
        signUpService.execute(request)
    }

    @PostMapping("/auth")
    fun signIn(@RequestBody request: SignInRequest): TokenResponse {
        return signInService.execute(request)
    }

    @PostMapping("/refresh")
    fun refresh(@RequestHeader("REFRESH-TOKEN") token: String): TokenResponse {
        return refreshTokenService.execute(token)
    }
}