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

    @field:NotNull
    var content = content

    fun todoComplete() {
        this.isDone = true
    }

    fun todoUpdate(title: String, content: String) {
        this.title = title
        this.content = content
    }

}