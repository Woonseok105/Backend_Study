package com.example.assignment.global.security.jwt

import com.example.assignment.domain.refreshToken.domain.RefreshTokenEntity
import com.example.assignment.domain.refreshToken.domain.RefreshTokenRepository
import com.example.assignment.domain.user.presentation.dto.response.TokenResponse
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class JwtProvider (
    private val securityProperties: SecurityProperties,
    private val refreshTokenRepository: RefreshTokenRepository
) {

    private fun generateToken(accountId: String, type: String, ttl: Long) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, securityProperties.secretKey)
            .setSubject(accountId)
            .setHeaderParam("type", "jwt")
            .claim("type", type)
            .setExpiration(Date(System.currentTimeMillis() + ttl* 1000))
            .compact()

    private fun createAccessToken(accountId: String) =
        generateToken(accountId, JwtProperties.ACCESS, securityProperties.accessExp)

    private fun createRefreshToken(accountId: String): String {
        val refreshToken = generateToken(accountId, JwtProperties.REFRESH, securityProperties.refreshExp)

        refreshTokenRepository.save(
            RefreshTokenEntity(
                accountId = accountId,
                token = refreshToken,
                expiredAt = securityProperties.refreshExp
            )
        )
        return refreshToken
    }


    fun provideBothToken(accountId: String) = TokenResponse (
        accessToken = createAccessToken(accountId),
        refreshToken = createRefreshToken(accountId),
        accessTokenExp = LocalDateTime.now().plusSeconds(securityProperties.accessExp)
    )
}