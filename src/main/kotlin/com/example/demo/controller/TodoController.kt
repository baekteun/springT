package com.example.demo.controller

import com.example.demo.service.TodoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
class TodoController (
    private val todoService: TodoService
){
    @GetMapping
    fun getTodos() = todoService.getTodos()

    @PostMapping
    fun insertTodo(@RequestBody todoReq: TodoRequestDTO) = todoService.insertTodo(todoReq.todoName)

    @PutMapping(path = ["/{todoId}"])
    fun updateTodo(@PathVariable("todoId") todoId: Long) = todoService.updateTodo(todoId)

    @DeleteMapping(path = ["/{todoId}"])
    fun deleteTodo(@PathVariable("todoId") todoId: Long) = todoService.deleteTodo(todoId)

}