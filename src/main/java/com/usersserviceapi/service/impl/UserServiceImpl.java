package com.usersserviceapi.service.impl;

import com.usersserviceapi.common.dto.UpdateUserRequest;
import com.usersserviceapi.common.dto.UserInfoResponse;
import com.usersserviceapi.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserInfoResponse getUserInfo(Long userId) {
        return null;
    }

    @Override
    public void UpdateUserInfo(UpdateUserRequest updateUserRequest, Long userId) {

    }

    @Override
    public void DeleteUserInfo(Long userId) {

    }
}
