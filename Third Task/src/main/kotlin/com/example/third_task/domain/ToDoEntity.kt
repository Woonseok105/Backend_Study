package com.example.third_task.domain

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "tbl_todo")
class ToDoEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    title: String,

    content: String,

    @field:NotNull
    var isDone: Boolean = false

) {

    @field:NotNull
    var title = title
        protected set

    @field:NotNull
    var content = content
        protected set

    fun todoUpdate(title: String, content: String, isDone: Boolean) {
        this.title = title
        this.content = content
        this.isDone = isDone
    }
}