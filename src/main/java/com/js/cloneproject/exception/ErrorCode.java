package com.js.cloneproject.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INVALID_KEY_ERROR(0000,"Invalid key to log error code"),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized Exception"),
    USER_EXISTED(1003, "User already exists"),
    USER_NOT_EXISTED(1004, "User not exists"),
    INVALID_PASSWORD(1002,"Password length at least 8 characters");
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.message = message;
        this.code = code;
    }


}
