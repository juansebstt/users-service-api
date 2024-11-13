package com.usersserviceapi.service;

import com.usersserviceapi.common.dto.UpdateUserRequest;
import com.usersserviceapi.common.dto.UserInfoResponse;

public interface UserService {

    UserInfoResponse getUserInfo(Long userId);

    void UpdateUserInfo(UpdateUserRequest updateUserRequest, Long userId);

    void DeleteUserInfo(Long userId);

}
