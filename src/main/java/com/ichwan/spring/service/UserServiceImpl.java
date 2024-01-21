package com.ichwan.spring.service;

import com.ichwan.spring.dto.RoleResponse;
import com.ichwan.spring.dto.UserRequest;
import com.ichwan.spring.dto.UserResponse;
import com.ichwan.spring.entity.Roles;
import com.ichwan.spring.entity.Users;
import com.ichwan.spring.repository.RoleRepository;
import com.ichwan.spring.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserResponse save(UserRequest userRequest) {
        Users user = new Users();
        user.setName(userRequest.name());
        user.setEmail(userRequest.email());
        user.setUsername(userRequest.username());
        user.setPassword(passwordEncoder.encode(userRequest.password()));

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return new UserResponse(user.getId(), user.getUsername(), jwtToken);
    }

    @Override
    public UserResponse findById(Long aLong) {
        Users user = userRepository.findById(aLong)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        return new UserResponse(user.getId(), user.getUsername(), null);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }

    @Override
    public UserResponse update(UserRequest userRequest, Long aLong) {
        Users user = userRepository.findById(aLong)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.setName(userRequest.name());
        user.setEmail(userRequest.email());
        user.setUsername(userRequest.username());
        user.setPassword(userRequest.password());
        userRepository.save(user);

        return new UserResponse(user.getId(), user.getUsername(), jwtService.generateToken(user));
    }

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(user.getId(), user.getUsername(), null))
                .toList();
    }

    @Override
    public RoleResponse assign(String username, String roleName) {
        Users user = userRepository.findByUsername(username);
        Roles role = new Roles();
        role.setRoleName(roleName);
        roleRepository.save(role);

        return new RoleResponse(role.getRoleName());
    }
}
