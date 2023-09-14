package com.example.assignment.domain.todo.presentation

import com.example.assignment.domain.todo.presentation.dto.request.ToDoAddRequest
import com.example.assignment.domain.todo.presentation.dto.request.ToDoSignInRequest
import com.example.assignment.domain.todo.presentation.dto.request.ToDoUpdateRequest
import com.example.assignment.domain.todo.presentation.dto.response.ToDoCheckResponse
import com.example.assignment.domain.todo.service.ToDoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

//import org.springframework.web.reactive.function.BodyInserters
//import org.springframework.web.reactive.function.client.WebClient

@RestController
@RequestMapping("/users/me/todos")
class ToDoController(
    private val toDoService: ToDoService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun addToDo(@RequestBody @Valid request: ToDoAddRequest) {
        toDoService.addToDo(request)
    }

    @GetMapping
    fun checkToDo(@RequestBody request: ToDoSignInRequest): ToDoCheckResponse {
        return toDoService.checkList(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody request: ToDoUpdateRequest) {
        toDoService.update(id, request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long, @RequestBody request: ToDoSignInRequest) {
        toDoService.delete(id, request)
    }

//    @PostMapping("/webClient")
//    fun webClient(@RequestBody request: ToDoAddRequest) {
//        val client = WebClient.create()
//
//        for (i in 1..1000) {
//            client.post()
//                .uri("http://localhost:8080/add")
//                .contentType(MediaType.APPLICATION_JSON) // 이 부분에 POST 요청으로 전송할 콘텐츠 타입 지정
//                .body(BodyInserters.fromValue(request)) // POST 요청으로 보낼 데이터 지정
//                .retrieve()
//                .bodyToMono(String::class.java)
//                .block()
//        }
//    }

    @GetMapping("/test")
    fun test(): String {
        return "TEST API"
    }
}