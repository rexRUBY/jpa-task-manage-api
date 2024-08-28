package com.sparta.taskmanagement.service;

import com.sparta.taskmanagement.dto.TodoRequestDto;
import com.sparta.taskmanagement.dto.TodoResponseDto;
import com.sparta.taskmanagement.entity.Todo;
import com.sparta.taskmanagement.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        return new TodoResponseDto(todoRepository.save(new Todo(requestDto)));
    }

    public TodoResponseDto getTodo(long todoId) {
        return todoRepository.findById(todoId)
                .map(TodoResponseDto::new)
                .orElseThrow(() -> new EntityNotFoundException("일정을 찾을 수 없습니다."));
    }


    public TodoResponseDto updateTodo(long todoId, TodoRequestDto requestDto) {
        Todo updateTodo = todoRepository.findById(todoId).orElseThrow(() -> new EntityNotFoundException("일정을 찾을 수 없습니다."));
        updateTodo.setUser(requestDto.getUser());
        updateTodo.setTitle(requestDto.getTitle());
        updateTodo.setContent(requestDto.getContent());

        return new TodoResponseDto(todoRepository.save(updateTodo));
    }
}
