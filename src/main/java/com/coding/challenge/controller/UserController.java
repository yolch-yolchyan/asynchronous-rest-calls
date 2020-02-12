package com.coding.challenge.controller;

import com.coding.challenge.dto.UserPostsDTO;
import com.coding.challenge.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<UserPostsDTO> getUser(@PathVariable final long id) {
        log.info("loading user data for user with id {}", id);

        return userService.getUserDataById(id);
    }

}
