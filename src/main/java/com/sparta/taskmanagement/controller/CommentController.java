package com.sparta.taskmanagement.controller;

import com.sparta.taskmanagement.dto.CommentRequestDto;
import com.sparta.taskmanagement.dto.CommentResponseDto;
import com.sparta.taskmanagement.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/api/comments/{todoId}")
    public CommentResponseDto createComment(@PathVariable Long todoId, @RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(todoId, requestDto);
    }

    @GetMapping("/api/comments/{commentId}")
    public CommentResponseDto getComment(@PathVariable Long commentId) {
        return commentService.getComment(commentId);
    }

    @GetMapping("/api/comments")
    public List<CommentResponseDto> getCommentList() {
        return commentService.getCommentList();
    }

    @PatchMapping("/api/comments/{commentId}")
    public CommentResponseDto updateComment(@PathVariable long commentId, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(commentId, requestDto);
    }

    @DeleteMapping("/api/comments/{commentId}")
    public void deleteComment(@PathVariable long commentId) {
        commentService.deleteComment(commentId);
    }
}
