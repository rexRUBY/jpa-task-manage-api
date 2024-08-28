package com.sparta.taskmanagement.dto;

import com.sparta.taskmanagement.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TodoResponseDto {
    private Long id;
    private List<UserResponseDto> userResponseDtos;
    private String title;
    private String content;
    private int commentCnt;
    private LocalDateTime created;
    private LocalDateTime modified;

    // 단건 조회 시 사용
    public TodoResponseDto(Todo saveTodo) {
            this.id = saveTodo.getId();
            this.userResponseDtos = saveTodo.getTodoUserList().stream()
                .map(todoUser -> new UserResponseDto(todoUser.getUser()))
                .collect(Collectors.toList());
            this.title = saveTodo.getTitle();
            this.content = saveTodo.getContent();
            this.commentCnt = saveTodo.getCommentList().size();
            this.created = saveTodo.getCreated();
            this.modified = saveTodo.getModified();
    }

    // 전체 조회 시 사용 - 생성자 오버로딩
    public TodoResponseDto(Todo saveTodo, boolean includeUsers) {
        this.id = saveTodo.getId();
        this.userResponseDtos = includeUsers ? saveTodo.getTodoUserList().stream()
                .map(todoUser -> new UserResponseDto(todoUser.getUser()))
                .collect(Collectors.toList()) : null;  // 유저 정보 없이 처리
        this.title = saveTodo.getTitle();
        this.content = saveTodo.getContent();
        this.commentCnt = saveTodo.getCommentList().size();
        this.created = saveTodo.getCreated();
        this.modified = saveTodo.getModified();
    }
}
