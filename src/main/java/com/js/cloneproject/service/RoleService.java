package com.js.cloneproject.service;
import com.js.cloneproject.dto.request.PermissionRequest;
import com.js.cloneproject.dto.request.RoleRequest;
import com.js.cloneproject.dto.response.PermissionResponse;
import com.js.cloneproject.dto.response.RoleResponse;
import com.js.cloneproject.entity.Permission;
import com.js.cloneproject.entity.Role;
import com.js.cloneproject.exception.AppException;
import com.js.cloneproject.exception.ErrorCode;
import com.js.cloneproject.mapper.PermissionMapper;
import com.js.cloneproject.mapper.RoleMapper;
import com.js.cloneproject.repository.PermissionRepository;
import com.js.cloneproject.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class RoleService {
    RoleRepository roleRepository;
    RoleMapper roleMapper;
    private final PermissionRepository permissionRepository;


    public RoleResponse createRole(RoleRequest roleRequest){
        if(roleRepository.existsByName(roleRequest.getName())){
            throw new AppException(ErrorCode.ROLE_EXISTED);
        }
        Role role = roleMapper.toRole(roleRequest);
        List<Permission> permissions = roleRequest.getPermissions().stream().map(s -> permissionRepository.findById(s).orElseThrow(
                () -> new AppException(ErrorCode.PERMISSION_NOT_EXISTED)
        )).toList();
        role.setPermissions(new HashSet<>(permissions));
        return roleMapper.toRoleResponse(roleRepository.save(role));
    }

    public List<RoleResponse> getAllRoles(){
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::toRoleResponse).toList();
    }

    public void deleteRole(String roleId){
        roleRepository.deleteById(roleId);
    }

}
