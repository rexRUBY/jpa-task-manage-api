package com.sparta.taskmanagement.dto;

import lombok.Getter;

@Getter
public class TodoRequestDto {
    private String user;
    private String title;
    private String content;
}
