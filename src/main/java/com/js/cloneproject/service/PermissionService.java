package com.js.cloneproject.service;
import com.js.cloneproject.dto.request.PermissionRequest;
import com.js.cloneproject.dto.response.PermissionResponse;
import com.js.cloneproject.entity.Permission;
import com.js.cloneproject.exception.AppException;
import com.js.cloneproject.exception.ErrorCode;
import com.js.cloneproject.mapper.PermissionMapper;
import com.js.cloneproject.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    @PreAuthorize("hasRole('ADMIN')")
    public PermissionResponse createPermission(PermissionRequest permissionRequest){
        if(permissionRepository.existsByName(permissionRequest.getName())){
            throw new AppException(ErrorCode.PERMISSION_EXISTED);
        }
        Permission permission = permissionMapper.toPermission(permissionRequest);
        return permissionMapper.toPermissionResponse(permissionRepository.save(permission));
    }

    public List<PermissionResponse> getAllPermission(){
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deletePermission(String permissionId){
        permissionRepository.deleteById(permissionId);
    }

}
