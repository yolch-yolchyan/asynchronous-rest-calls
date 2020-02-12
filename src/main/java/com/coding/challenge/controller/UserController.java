package com.coding.challenge.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping("users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<Void> getUser(@PathVariable final long id) {
        throw new RuntimeException("not implemented yet");
    }

}
