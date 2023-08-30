package com.example.assignment.domain.user.service

import com.example.assignment.domain.user.domain.UserEntity
import com.example.assignment.domain.user.domain.UserRepository
import com.example.assignment.domain.user.exception.UserAlreadyExistException
import com.example.assignment.domain.user.presentation.dto.SignUpRequest
import org.springframework.stereotype.Service

@Service
class SignUpService(
    private val userRepository: UserRepository
) {
    fun execute(request: SignUpRequest) {

        if (userRepository.existsByAccountId(request.accountId)) {
            throw UserAlreadyExistException
        }

        userRepository.save(
            UserEntity(
                accountId = request.accountId,
                password = request.password
            )
        )
    }
}