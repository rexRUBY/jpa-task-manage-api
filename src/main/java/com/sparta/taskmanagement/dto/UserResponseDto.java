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
    private String passWord;
    private LocalDateTime created;
    private LocalDateTime modified;
    private String jwtToken;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.passWord = user.getPassword();
        this.created = user.getCreated();
        this.modified = user.getModified();
    }
}