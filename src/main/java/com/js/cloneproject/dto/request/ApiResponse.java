package com.js.cloneproject.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)//annotation giup loai bo cac gia tri null ra khoi response
public class ApiResponse<T> {
    int code;
    String message;
    T result;
}
