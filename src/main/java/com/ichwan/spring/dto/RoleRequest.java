package com.ichwan.spring.dto;

import jakarta.validation.constraints.NotBlank;

public record RoleRequest(@NotBlank String roleName) {
}
