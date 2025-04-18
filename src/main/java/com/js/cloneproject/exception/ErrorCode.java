package com.js.cloneproject.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    INVALID_KEY_ERROR(0,"Invalid key to log error code", HttpStatus.INTERNAL_SERVER_ERROR),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized Exception", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1003, "User already exists", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1004, "User not exists", HttpStatus.NOT_FOUND),
    INVALID_PASSWORD(1002,"Password length at least 8 characters", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1001, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    PERMISSION_EXISTED(1005,"Permission already exists",HttpStatus.BAD_REQUEST),
    ROLE_EXISTED(1005,"Role already exists", HttpStatus.BAD_REQUEST),
    PERMISSION_NOT_EXISTED(1006,"Permission not exists", HttpStatus.NOT_FOUND),
    UNAUTHORIZED(1007,"You do not have permission", HttpStatus.FORBIDDEN),
    INVALID_DOB(2001,"You do not have enough age for regis", HttpStatus.BAD_REQUEST),
    ;
    private final int code;
    private final String message;
    private final HttpStatusCode httpStatusCode;

    ErrorCode(int code, String message, HttpStatusCode httpStatusCode) {
        this.message = message;
        this.code = code;
        this.httpStatusCode = httpStatusCode;
    }


}
