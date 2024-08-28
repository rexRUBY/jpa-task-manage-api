package com.sparta.taskmanagement.controller;

import com.sparta.taskmanagement.dto.TodoRequestDto;
import com.sparta.taskmanagement.dto.TodoResponseDto;
import com.sparta.taskmanagement.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("api/todos")
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto requestDto) {
        return todoService.createTodo(requestDto);
    }

    @GetMapping("/api/todos/{todoId}")
    public TodoResponseDto getTodo(@PathVariable long todoId) {
        return todoService.getTodo(todoId);
    }

    @GetMapping("/api/todos")
    public List<TodoResponseDto> getTodos(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return todoService.getTodos(page, size);
    }

    @PatchMapping("/api/todos/{todoId}")
    public TodoResponseDto updateTodo(@PathVariable long todoId, @RequestBody TodoRequestDto requestDto) {
        return todoService.updateTodo(todoId, requestDto);
    }

    @DeleteMapping("/api/todos/{todoId}")
    public void deleteDto(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
    }
}
