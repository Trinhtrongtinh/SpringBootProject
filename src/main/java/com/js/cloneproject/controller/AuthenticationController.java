package com.js.cloneproject.controller;

import com.js.cloneproject.dto.request.ApiResponse;
import com.js.cloneproject.dto.request.AuthenticationRequest;
import com.js.cloneproject.dto.response.AuthenticationResponse;
import com.js.cloneproject.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService; // Thêm "private final"

    @PostMapping("/log-in")
    public ApiResponse<AuthenticationResponse> Authentication(@RequestBody AuthenticationRequest request) {
        System.out.println(request);
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }
}

