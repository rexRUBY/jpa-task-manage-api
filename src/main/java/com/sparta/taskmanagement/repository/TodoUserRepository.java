package com.sparta.taskmanagement.repository;

import com.sparta.taskmanagement.entity.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoUserRepository extends JpaRepository<TodoUser, Long> {
}
