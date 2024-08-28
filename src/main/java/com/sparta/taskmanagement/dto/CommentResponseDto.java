package com.sparta.taskmanagement.dto;

import com.sparta.taskmanagement.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CommentResponseDto {
    Long id;
    String user;
    String content;
    LocalDateTime created;
    LocalDateTime modified;

    public CommentResponseDto(Comment saveComment) {
        this.id = saveComment.getId();
        this.user = saveComment.getUser();
        this.content = saveComment.getContent();
        this.created = saveComment.getCreated();
        this.modified = saveComment.getModified();
    }
}
