package com.sparta.taskmanagement.entity;

import com.sparta.taskmanagement.dto.TodoRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todo")
public class Todo extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user", nullable = false)
    private String user;
    private String title;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    public Todo(TodoRequestDto requestDto) {
        this.user = requestDto.getUser();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    @OneToMany(mappedBy = "todo", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();
}
