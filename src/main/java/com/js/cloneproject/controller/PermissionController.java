package com.js.cloneproject.controller;
import com.js.cloneproject.dto.request.ApiResponse;
import com.js.cloneproject.dto.request.PermissionRequest;
import com.js.cloneproject.dto.response.PermissionResponse;
import com.js.cloneproject.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/permissions")
@FieldDefaults(level= AccessLevel.PRIVATE, makeFinal = true)
public class PermissionController {
    PermissionService permissionService;
    @PostMapping()
    ApiResponse<PermissionResponse>  createPermissions(@RequestBody PermissionRequest permissionRequest){
        return ApiResponse.<PermissionResponse>builder()
                .result(permissionService.createPermission(permissionRequest))
                .build();
    }


    @GetMapping()
    ApiResponse<List<PermissionResponse>> getAllPermissions(){
        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissionService.getAllPermission())
                .build();
    }

    @DeleteMapping("/{permissionId}")
    ApiResponse<Void> deletePermission(@PathVariable String permissionId){
        permissionService.deletePermission(permissionId);
        return ApiResponse.<Void>builder().build();
    }

}

