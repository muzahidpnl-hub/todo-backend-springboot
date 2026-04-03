package com.example.todo.service;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public String getHelloWorld() {
        return "Hello World from TodoService!";
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public @Nullable Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodo(Todo todo) {
        todoRepository.delete(todo);
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }
}
