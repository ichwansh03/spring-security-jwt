package com.ichwan.spring.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRequest(@NotBlank String name, @NotBlank String email ,@NotBlank String username, @NotBlank String password) {
}
