package com.sparta.taskmanagement.controller;

import com.sparta.taskmanagement.dto.TodoRequestDto;
import com.sparta.taskmanagement.dto.TodoResponseDto;
import com.sparta.taskmanagement.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("api/todo")
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto requestDto) {
        return todoService.createTodo(requestDto);
    }

    @GetMapping("/api/todo/{todoId}")
    public TodoResponseDto getTodo(@PathVariable long todoId) {
        return todoService.getTodo(todoId);
    }

    @PatchMapping("/api/todo/{todoId}")
    public TodoResponseDto updateTodo(@PathVariable long todoId, @RequestBody TodoRequestDto requestDto) {
        return todoService.updateTodo(todoId, requestDto);
    }


}
