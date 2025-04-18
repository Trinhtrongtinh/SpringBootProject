package com.js.cloneproject.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.js.cloneproject.dto.request.ApiResponse;
import com.js.cloneproject.dto.request.UserCreationRequest;
import com.js.cloneproject.dto.request.UserUpdateRequest;
import com.js.cloneproject.dto.response.UserResponse;
import com.js.cloneproject.entity.User;
import com.js.cloneproject.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping()
    ApiResponse <UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }


    @GetMapping
    ApiResponse<List<UserResponse>> getAllUsers() {
        log.info("Get all users");
        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }


    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String id) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUser(id))
                .build();
    }

    @GetMapping("/myinfo")
    ApiResponse<UserResponse> getUser() {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyinfo())
                .build();
    }

    @PutMapping("/{userId}")
    ApiResponse<UserResponse> updateUser(@PathVariable("userId") String id, @RequestBody @Valid UserUpdateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUserById(id, request))
                .build();
    }

    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable("userId") String id) {
        userService.deleteUserById(id);
    }
}
