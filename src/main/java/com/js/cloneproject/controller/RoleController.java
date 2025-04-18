package com.js.cloneproject.controller;
import com.js.cloneproject.dto.request.ApiResponse;
import com.js.cloneproject.dto.request.PermissionRequest;
import com.js.cloneproject.dto.request.RoleRequest;
import com.js.cloneproject.dto.response.PermissionResponse;
import com.js.cloneproject.dto.response.RoleResponse;
import com.js.cloneproject.service.PermissionService;
import com.js.cloneproject.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
@FieldDefaults(level= AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {
    RoleService roleService;
    @PostMapping()
    ApiResponse<RoleResponse>  createPermissions(@RequestBody RoleRequest roleRequest){
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.createRole(roleRequest))
                .build();
    }


    @GetMapping()
    ApiResponse<List<RoleResponse>> getAllRoles(){
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAllRoles())
                .build();
    }

    @DeleteMapping("/{roleId}")
    ApiResponse<Void> deletePermission(@PathVariable String roleId){
        roleService.deleteRole(roleId);
        return ApiResponse.<Void>builder().build();
    }

}

