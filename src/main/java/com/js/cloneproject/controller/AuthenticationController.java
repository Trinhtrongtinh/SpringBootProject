package com.js.cloneproject.controller;

import com.js.cloneproject.dto.request.ApiResponse;
import com.js.cloneproject.dto.request.AuthenticationRequest;
import com.js.cloneproject.dto.response.AuthenticationResponse;
import com.js.cloneproject.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    AuthenticationService authenticationService;
    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> Authentication(AuthenticationRequest request){
        boolean result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(AuthenticationResponse.builder()
                        .authenticated(result)
                        .build())
                .build();
    }


}
