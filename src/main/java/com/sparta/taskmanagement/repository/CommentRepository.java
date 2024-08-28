package com.sparta.taskmanagement.repository;

import com.sparta.taskmanagement.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
