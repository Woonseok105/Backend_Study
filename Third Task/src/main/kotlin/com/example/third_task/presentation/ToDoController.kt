package com.example.third_task.presentation

import com.example.third_task.service.ToDoService
import com.example.third_task.presentation.dto.request.ToDoAddRequest
import com.example.third_task.presentation.dto.request.ToDoUpdateRequest
import com.example.third_task.presentation.dto.response.ToDoCheckResponse
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ToDoController(
    private val toDoService: ToDoService
) {

    @PostMapping("/add")
    fun addToDo(@RequestBody request: ToDoAddRequest) {
        toDoService.addToDo(request)
    }

    @GetMapping("/check")
    fun checkToDo(): ToDoCheckResponse {
        return toDoService.checkList()
    }

    @PutMapping("/update/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody request: ToDoUpdateRequest) {
        toDoService.update(id, request)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long) {
        toDoService.delete(id)
    }
}