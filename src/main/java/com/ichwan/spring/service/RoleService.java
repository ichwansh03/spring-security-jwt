package com.ichwan.spring.service;

import com.ichwan.spring.dto.RoleRequest;
import com.ichwan.spring.dto.RoleResponse;
import com.ichwan.spring.enumeration.PermissionType;

public interface RoleService extends BaseService<RoleResponse, RoleRequest, Long> {

    RoleResponse apply(String roleName, PermissionType permissionType);
}
