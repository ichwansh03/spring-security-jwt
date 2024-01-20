package com.ichwan.spring.dto;

import com.ichwan.spring.enumeration.PermissionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RoleRequest(@NotBlank String roleName) {
}
