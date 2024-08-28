package com.sparta.taskmanagement.service;

import com.sparta.taskmanagement.dto.TodoRequestDto;
import com.sparta.taskmanagement.dto.TodoResponseDto;
import com.sparta.taskmanagement.entity.Comment;
import com.sparta.taskmanagement.entity.Todo;
import com.sparta.taskmanagement.entity.TodoUser;
import com.sparta.taskmanagement.entity.User;
import com.sparta.taskmanagement.repository.TodoRepository;
import com.sparta.taskmanagement.repository.TodoUserRepository;
import com.sparta.taskmanagement.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private final TodoUserRepository todoUserRepository;

    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        Todo todo = new Todo(requestDto);

        // 일정과 유저의 관계 설정
        List<Long> userIds = requestDto.getUserIds();
        for(Long userId : userIds) {
            User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("유저를 찾을 수 없습니다."));

            TodoUser todoUser = new TodoUser();
            todoUser.setUser(user);
            todoUser.setTodo(todo);

            // 양방향 관계 설정
            todo.getTodoUserList().add(todoUser);
            user.getTodoUserList().add(todoUser);

            todoUserRepository.save(todoUser);
        }

        //Todo 저장
        Todo savedTodo = todoRepository.save(todo);
        return new TodoResponseDto(savedTodo);
    }

    public TodoResponseDto getTodo(long todoId) {
        return todoRepository.findById(todoId)
                .map(TodoResponseDto::new)
                .orElseThrow(() -> new EntityNotFoundException("일정을 찾을 수 없습니다."));
    }

    public TodoResponseDto updateTodo(long todoId, TodoRequestDto requestDto) {
        Todo updateTodo = todoRepository.findById(todoId)
                .orElseThrow(() -> new EntityNotFoundException("일정을 찾을 수 없습니다."));

        updateTodo.setTitle(requestDto.getTitle());
        updateTodo.setContent(requestDto.getContent());

        // 기존 사용자와의 연관 관계를 제거
        updateTodo.getTodoUserList().clear();
        for(Long userId : requestDto.getUserIds()) {
            User user = userRepository.findById(userId).orElseThrow(()-> new EntityNotFoundException("유저가 존재하지 않습니다."));

            TodoUser todoUser = new TodoUser();
            todoUser.setTodo(updateTodo);
            todoUser.setUser(user);

            updateTodo.getTodoUserList().add(todoUser);
        }

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
