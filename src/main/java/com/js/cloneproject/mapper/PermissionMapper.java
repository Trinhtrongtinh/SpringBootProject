package com.js.cloneproject.mapper;
import com.js.cloneproject.dto.request.PermissionRequest;
import com.js.cloneproject.dto.request.UserCreationRequest;
import com.js.cloneproject.dto.request.UserUpdateRequest;
import com.js.cloneproject.dto.response.PermissionResponse;
import com.js.cloneproject.dto.response.RoleResponse;
import com.js.cloneproject.dto.response.UserResponse;
import com.js.cloneproject.entity.Permission;
import com.js.cloneproject.entity.Role;
import com.js.cloneproject.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    /* @Mapping(source = "", target = "") Nghĩa là nó sẽ mapping các fields của target và source
    *  @Mapping(target = "", ignore = true) Nghĩa là nó sẽ mapping tất cả các fields trừ target
    * */
    void updatePermission(@MappingTarget Permission permission, PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);


}
