package com.usersserviceapi.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoResponse {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String role;
}
