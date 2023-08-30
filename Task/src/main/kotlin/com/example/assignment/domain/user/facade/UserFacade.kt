package com.example.assignment.domain.user.facade

import com.example.assignment.domain.user.domain.UserEntity
import com.example.assignment.domain.user.domain.UserRepository
import com.example.assignment.domain.user.exception.UserNotFoundException
import org.springframework.stereotype.Component

@Component
class UserFacade (
    private val userRepository: UserRepository
) {

    fun getUserByAccountId(accountId: String): UserEntity {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
    }
}