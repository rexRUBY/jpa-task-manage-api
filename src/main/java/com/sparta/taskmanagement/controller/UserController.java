package com.sparta.taskmanagement.controller;

import com.sparta.taskmanagement.dto.UserRequestDto;
import com.sparta.taskmanagement.dto.UserResponseDto;
import com.sparta.taskmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users")
    public UserResponseDto createUser(@RequestBody UserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @GetMapping("/api/users/{userId}")
    public UserResponseDto getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/api/users")
    public List<UserResponseDto> getUserList() {
        return userService.getUserList();
    }

    @PatchMapping("/{userId}")
    public UserResponseDto updateUser(@PathVariable Long userId, @RequestBody UserRequestDto requestDto) {
        return userService.updateUser(userId, requestDto);
    }

    @DeleteMapping("/api/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @PostMapping("api/users/signup")
    public String signup(@RequestBody UserRequestDto requestDto) {
        return userService.signup(requestDto);
    }
}
