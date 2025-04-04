package com.js.cloneproject.dto.response;

import com.js.cloneproject.enums.Role;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String username;
    String firstName;
    String lastName;
    LocalDate birthDate;
    Set<String> roles;
}
