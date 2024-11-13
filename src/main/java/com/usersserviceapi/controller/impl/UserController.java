package com.usersserviceapi.controller.impl;

import com.usersserviceapi.common.dto.UpdateUserRequest;
import com.usersserviceapi.common.dto.UserInfoResponse;
import com.usersserviceapi.controller.UserApi;
import com.usersserviceapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserInfoResponse> getUserInfo(Long userId) {
        return ResponseEntity.ok(userService.getUserInfo(userId));
    }

    @Override
    public ResponseEntity<Void> updateUserInfo(UpdateUserRequest updateUserRequest, Long userId) {
        userService.UpdateUserInfo(updateUserRequest, userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        userService.DeleteUserInfo(userId)
        return ResponseEntity.noContent().build();
    }
    
}
