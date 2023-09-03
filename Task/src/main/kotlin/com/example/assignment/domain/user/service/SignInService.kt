package com.example.assignment.domain.user.service

import com.example.assignment.domain.user.domain.UserEntity
import com.example.assignment.domain.user.domain.UserRepository
import com.example.assignment.domain.user.exception.UnAuthorizedException
import com.example.assignment.domain.user.exception.UserNotFoundException
import com.example.assignment.domain.user.facade.UserFacade
import com.example.assignment.domain.user.presentation.dto.request.SignInRequest
import com.example.assignment.domain.user.presentation.dto.response.TokenResponse
import com.example.assignment.global.security.jwt.JwtProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SignInService(
    private val userFacade: UserFacade,
    private val jwtProvider: JwtProvider,
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository
) {

    fun execute(request: SignInRequest): TokenResponse {

        val user = userRepository.findByAccountId(request.accountId)
            ?: throw UnAuthorizedException


        if (!passwordEncoder.matches(request.password, user.password))
            throw UnAuthorizedException


        return jwtProvider.provideBothToken(user.accountId)
    }
}