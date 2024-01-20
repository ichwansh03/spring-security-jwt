package com.ichwan.spring.controller;

import com.ichwan.spring.dto.UserRequest;
import com.ichwan.spring.dto.UserResponse;
import com.ichwan.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        UserResponse byId = userService.findById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.save(userRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.update(userRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
