package com.ichwan.spring.service;

import com.ichwan.spring.dto.RoleResponse;
import com.ichwan.spring.dto.UserRequest;
import com.ichwan.spring.dto.UserResponse;

public interface UserService extends BaseService<UserResponse, UserRequest, Long>{

    RoleResponse assign(String username, String roleName);
}
