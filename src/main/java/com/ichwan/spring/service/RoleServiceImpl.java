package com.ichwan.spring.service;

import com.ichwan.spring.dto.RoleRequest;
import com.ichwan.spring.dto.RoleResponse;
import com.ichwan.spring.enumeration.PermissionType;
import com.ichwan.spring.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleResponse save(RoleRequest roleRequest) {
        return null;
    }

    @Override
    public RoleResponse findById(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public RoleResponse update(RoleRequest roleRequest, Long aLong) {
        return null;
    }

    @Override
    public List<RoleResponse> findAll() {
        return null;
    }

    @Override
    public RoleResponse apply(String roleName, PermissionType permissionType) {
        return null;
    }
}
