package com.sparta.taskmanagement.service;

import com.sparta.taskmanagement.dto.CommentRequestDto;
import com.sparta.taskmanagement.dto.CommentResponseDto;
import com.sparta.taskmanagement.entity.Comment;
import com.sparta.taskmanagement.entity.Todo;
import com.sparta.taskmanagement.repository.CommentRepository;
import com.sparta.taskmanagement.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;

    public CommentResponseDto createComment(Long todoId, CommentRequestDto requestDto) {
        Todo commentedTodo = todoRepository.findById(todoId)
                .orElseThrow(() -> new EntityNotFoundException("일정을 찾을 수 없습니다."));

        Comment comment = new Comment();
        comment.setContent(requestDto.getContent());
        comment.setUser(requestDto.getUser());
        comment.setTodo(commentedTodo);
        commentedTodo.getCommentList().add(comment);
        commentRepository.save(comment);

        return new CommentResponseDto(comment);
    }

    public CommentResponseDto getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없습니다."));
        return new CommentResponseDto(comment);
    }

    public List<CommentResponseDto> getCommentList() {
        return commentRepository.findAll().stream().map(CommentResponseDto::new).toList();
    }

    public CommentResponseDto updateComment(long commentId, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없습니다."));
        comment.setUser(requestDto.getUser());
        comment.setContent(requestDto.getContent());
        return new CommentResponseDto(commentRepository.save(comment));
    }


    public void deleteComment(long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없습니다."));
        commentRepository.delete(comment);
    }
}
