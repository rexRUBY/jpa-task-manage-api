package com.sparta.taskmanagement.dto;

import com.sparta.taskmanagement.entity.Todo;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {
    private Long id;
    private String user;
    private String title;
    private String content;
    private int commentCnt;
    private LocalDateTime created;
    private LocalDateTime modified;

    public TodoResponseDto(Todo saveTodo) {
            this.id = saveTodo.getId();
            this.user = saveTodo.getUser();
            this.title = saveTodo.getTitle();
            this.content = saveTodo.getContent();
            this.commentCnt = saveTodo.getCommentList().size();
            this.created = saveTodo.getCreated();
            this.modified = saveTodo.getModified();
    }
}
