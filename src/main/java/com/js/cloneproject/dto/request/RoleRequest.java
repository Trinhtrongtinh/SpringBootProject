package com.js.cloneproject.dto.request;

import com.js.cloneproject.entity.Permission;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleRequest
{
    String name;
    String description;
    Set<String> permissions;
}
