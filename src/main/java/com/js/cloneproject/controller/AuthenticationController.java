package com.js.cloneproject.controller;

import com.js.cloneproject.dto.request.ApiResponse;
import com.js.cloneproject.dto.request.AuthenticationRequest;
import com.js.cloneproject.dto.request.IntrospectRequest;
import com.js.cloneproject.dto.response.AuthenticationResponse;
import com.js.cloneproject.dto.response.IntrospectResponse;
import com.js.cloneproject.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService; // Thêm "private final"

    @PostMapping("/token")
    public ApiResponse<AuthenticationResponse> Authentication(@RequestBody AuthenticationRequest request) {
        System.out.println(request);
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }
    @PostMapping("/introspect")
    public ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}

