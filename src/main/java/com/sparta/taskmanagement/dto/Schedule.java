package com.sparta.taskmanagement.dto;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "schedule")
@EntityListeners(AuditingEntityListener.class)
public class Schedule {
    private
    private String user;
    private String title;
    private String content;
    private LocalDateTime created;
    private LocalDateTime modified;
}
