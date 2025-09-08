package com.home.redis_cache_demo.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.redis_cache_demo.domain.User;
import com.home.redis_cache_demo.service.UserService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(
        @PathVariable final Long userId
    ) {
        final var user = userService.getUser(userId);
        return user != null
            ? ResponseEntity.ok(user)
            : ResponseEntity.notFound().build();
    }

}
