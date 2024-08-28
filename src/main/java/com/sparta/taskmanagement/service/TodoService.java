package com.sparta.taskmanagement.service;

import com.sparta.taskmanagement.dto.TodoRequestDto;
import com.sparta.taskmanagement.dto.TodoResponseDto;
import com.sparta.taskmanagement.entity.Comment;
import com.sparta.taskmanagement.entity.Todo;
import com.sparta.taskmanagement.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<TodoResponseDto> getTodos(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "modified");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Todo> todoPage = todoRepository.findAll(pageable);
        return todoPage.getContent().stream()
                .map(TodoResponseDto::new)
                .toList();
    }

    public void deleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new EntityNotFoundException("일정을 찾을 수 없습니다."));
        todoRepository.delete(todo);
    }
}
