package com.example.third_task.presentation

import com.example.third_task.presentation.dto.request.ToDoAddRequest
import com.example.third_task.presentation.dto.request.ToDoUpdateRequest
import com.example.third_task.presentation.dto.response.ToDoCheckResponse
import com.example.third_task.service.ToDoService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient

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

    @PostMapping("/webClient")
    fun webClient(@RequestBody request: ToDoAddRequest) {
        val client = WebClient.create()

        for (i in 1..1000) {
            client.post()
                .uri("http://localhost:8080/add")
                .contentType(MediaType.APPLICATION_JSON) // 이 부분에 POST 요청으로 전송할 콘텐츠 타입 지정
                .body(BodyInserters.fromValue(request)) // POST 요청으로 보낼 데이터 지정
                .retrieve()
                .bodyToMono(String::class.java)
                .block()
        }
    }
}