package com.js.cloneproject.service;

import com.js.cloneproject.dto.request.UserCreationRequest;
import com.js.cloneproject.dto.request.UserUpdateRequest;
import com.js.cloneproject.dto.response.UserResponse;
import com.js.cloneproject.entity.User;
import com.js.cloneproject.enums.Role;
import com.js.cloneproject.exception.AppException;
import com.js.cloneproject.exception.ErrorCode;
import com.js.cloneproject.mapper.UserMapper;
import com.js.cloneproject.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserResponse createUser(UserCreationRequest request){
        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
         }
        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(roles);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"))
        );
    }

    public UserResponse updateUserById(String id, UserUpdateRequest request) {
        User user = new User();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUserById(String id) {
        System.out.println("Delete user by id: " + id);
        userRepository.deleteById(id);
        System.out.println("Delete user by id: " + id);
    }
}
