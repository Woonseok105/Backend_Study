package com.example.assignment.domain.user.domain

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, Long> {

    fun existsByAccountId(accountId: String): Boolean
    fun findByAccountId(accountId: String): UserEntity?
}