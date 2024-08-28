package com.sparta.taskmanagement.dto;

import com.sparta.taskmanagement.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime created;
    private LocalDateTime modified;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.created = user.getCreated();
        this.modified = user.getModified();
    }
}