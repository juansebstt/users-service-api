package com.usersserviceapi.controller;

import com.usersserviceapi.common.constant.ApiPathConstants;
import com.usersserviceapi.common.dto.UpdateUserRequest;
import com.usersserviceapi.common.dto.UserInfoResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.USER_ROUTE)
public interface UserApi {

    @GetMapping
    ResponseEntity<UserInfoResponse> getUserInfo(@RequestAttribute("X-User-Id") Long userId);

    @PutMapping(value = "/update_user_info/{userId}")
    ResponseEntity<Void> updateUserInfo(@RequestBody @Valid UpdateUserRequest updateUserRequest,
                                        @RequestAttribute(name = "X-User-Id") Long userId
    );

    @DeleteMapping(value = "/delete_user{userId}")
    ResponseEntity<Void> deleteUser(@PathVariable Long userId);
    

}
