package com.js.cloneproject.mapper;
import com.js.cloneproject.dto.request.PermissionRequest;
import com.js.cloneproject.dto.request.RoleRequest;
import com.js.cloneproject.dto.response.PermissionResponse;
import com.js.cloneproject.dto.response.RoleResponse;
import com.js.cloneproject.entity.Permission;
import com.js.cloneproject.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);
    /* @Mapping(source = "", target = "") Nghĩa là nó sẽ mapping các fields của target và source
    *  @Mapping(target = "", ignore = true) Nghĩa là nó sẽ mapping tất cả các fields trừ target
    * */
    RoleResponse toRoleResponse(Role role);


}
