package com.ichwan.spring.repository;

import com.ichwan.spring.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
}
