package com.example.assignment.domain.user.domain

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "tbl_user")
class UserEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    accountId: String,

    password: String

) {

    @Column(unique = true)
    @field:NotNull
    var accountId = accountId
        protected set

    @field:NotNull
    var password = password
        protected set
}