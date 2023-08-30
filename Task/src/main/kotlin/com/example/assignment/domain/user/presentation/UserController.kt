package com.example.assignment.domain.user.presentation

import com.example.assignment.domain.user.presentation.dto.SignUpRequest
import com.example.assignment.domain.user.service.SignUpService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController (
    private val signUpService: SignUpService
) {

    @PostMapping("/register")
    fun signUp(@RequestBody request: SignUpRequest) {
        signUpService.execute(request)
    }
}