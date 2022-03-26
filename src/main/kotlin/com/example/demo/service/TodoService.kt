package com.example.demo.service

import com.example.demo.repository.Todo
import com.example.demo.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TodoService(
    private val todoRepository: TodoRepository
) {
    fun getTodos() = todoRepository.findAll()

    fun insertTodo(todoName: String): Todo = todoRepository.save(Todo(todoName = todoName))

    fun updateTodo(todoId: Long): Todo {
        val todo = todoRepository.findByIdOrNull(id = todoId) ?: throw Exception()
        todo.completed = !todo.completed
        return todoRepository.save(todo)
    }

    fun deleteTodo(todoId: Long) = todoRepository.deleteById(todoId)
}