package com.example.assignment.domain.user.service

import com.example.assignment.domain.refreshToken.domain.RefreshTokenRepository
import com.example.assignment.domain.user.exception.RefreshTokenNotFound
import com.example.assignment.domain.user.presentation.dto.response.TokenResponse
import com.example.assignment.global.security.jwt.JwtProvider
import com.example.assignment.global.security.jwt.SecurityProperties
import org.springframework.stereotype.Service

@Service
class RefreshTokenService(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtProvider: JwtProvider,
    private val securityProperties: SecurityProperties
) {

    fun execute(token: String): TokenResponse {
        val refreshToken = refreshTokenRepository.findByToken(token)
            ?: throw RefreshTokenNotFound

        val newBothToken = jwtProvider.provideBothToken(refreshToken.accountId)

        refreshToken.updateToken(newBothToken.refreshToken, securityProperties.refreshExp)

        return newBothToken
    }
}