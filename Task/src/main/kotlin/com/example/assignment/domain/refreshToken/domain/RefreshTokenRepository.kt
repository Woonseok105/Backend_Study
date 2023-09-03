package com.example.assignment.domain.refreshToken.domain

import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {
    fun findByToken(token: String): RefreshTokenEntity?
}