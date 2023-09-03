package com.example.assignment.domain.refreshToken.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshTokenEntity (

    @Id
    val accountId: String,

    @Indexed
    var token: String,

    @TimeToLive
    var expiredAt: Long

) {
    fun updateToken(token: String, expiredAt: Long) {
        this.token = token
        this.expiredAt = expiredAt
    }
}