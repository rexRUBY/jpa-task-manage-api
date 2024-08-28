package com.sparta.taskmanagement.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class TodoRequestDto {
    private List<Long> userIds;
    private String email;
    private String title;
    private String content;
}
