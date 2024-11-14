package com.usersserviceapi.service.impl;

import com.usersserviceapi.common.dto.UpdateUserRequest;
import com.usersserviceapi.common.dto.UserInfoResponse;
import com.usersserviceapi.common.entity.UserModel;
import com.usersserviceapi.repository.UserRepository;
import com.usersserviceapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserInfoResponse getUserInfo(Long userId) {
        return Optional.of(userId)
                .map(this::getUserById)
                .map(this::mapToUserInfo)
                .orElseThrow(() -> new RuntimeException("Error user not found by ID"));
    }

    private UserInfoResponse mapToUserInfo(UserModel user) {
        return UserInfoResponse.builder()
                .id(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    private UserModel getUserById(Long userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Error user not found by ID"));
    }

    @Override
    public void UpdateUserInfo(UpdateUserRequest updateUserRequest, Long userId) {
        Optional.of(userId)
                .map(this::getUserById)
                .map(existingUser -> updateUserFields(existingUser, updateUserRequest))
                .map(userRepository::save)
                .orElseThrow(() -> new RuntimeException("Error updating user"));

    }

    private UserModel updateUserFields(UserModel existingUser, UpdateUserRequest updateUserRequest) {
        return UserModel.builder()
                .firstName(updateUserRequest.getFirstName())
                .lastName(updateUserRequest.getLastName())
                .email(updateUserRequest.getEmail())
                .build();
    }

    @Override
    public void DeleteUserInfo(Long userId) {
        Optional.of(userId)
                .map(this::getUserById)
                .ifPresent(userRepository::delete);
    }
}
