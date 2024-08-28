package com.sparta.taskmanagement.dto;

import com.sparta.taskmanagement.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TodoResponseDto {
    private Long id;
    private List<Long> userIds;
    private String title;
    private String content;
    private int commentCnt;
    private LocalDateTime created;
    private LocalDateTime modified;

    public TodoResponseDto(Todo saveTodo) {
            this.id = saveTodo.getId();
            // 이 부분이 너~~~무 어려웠다 ㅠㅠ
            this.userIds = saveTodo.getTodoUserList().stream()
                .map(todoUser -> todoUser.getUser().getId())
                .collect(Collectors.toList());
            this.title = saveTodo.getTitle();
            this.content = saveTodo.getContent();
            this.commentCnt = saveTodo.getCommentList().size();
            this.created = saveTodo.getCreated();
            this.modified = saveTodo.getModified();
    }
}
