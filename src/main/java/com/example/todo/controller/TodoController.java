package com.example.todo.controller;

import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;

import com.example.todo.model.Todo;

import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/hello")
    public String helloWorld() {
        return todoService.getHelloWorld();
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.createTodo(todo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<@Nullable Object> getTodoById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTodo(@RequestBody Todo todo) {
        if (todoService.getTodoById(todo.getId()).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        todoService.deleteTodo(todo);
        return ResponseEntity.noContent().build();
    }

}
