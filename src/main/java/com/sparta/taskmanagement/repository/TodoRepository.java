package com.sparta.taskmanagement.repository;

import com.sparta.taskmanagement.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
