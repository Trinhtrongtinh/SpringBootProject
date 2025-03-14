package com.js.cloneproject.mapper;
import com.js.cloneproject.dto.request.UserCreationRequest;
import com.js.cloneproject.dto.request.UserUpdateRequest;
import com.js.cloneproject.dto.response.UserResponse;
import com.js.cloneproject.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    /* @Mapping(source = "", target = "") Nghĩa là nó sẽ mapping các fields của target và source
    *  @Mapping(target = "", ignore = true) Nghĩa là nó sẽ mapping tất cả các fields trừ target
    * */
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
    UserResponse toUserResponse(User user);


}
