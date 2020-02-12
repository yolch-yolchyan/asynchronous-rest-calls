package com.coding.challenge.service;

import com.coding.challenge.dto.PostDTO;
import com.coding.challenge.dto.UserDTO;
import com.coding.challenge.dto.UserPostsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final String USER_DATA_URL = "users/{id}";
    private static final String USER_POSTS_URL = "posts?userId=%s";

    @Value("${coding.challenge.api.url}")
    private String externalApiUrl;

    private final RestTemplate restTemplate;


    public CompletableFuture<UserPostsDTO> getUserDataById(final Long id) {
        final CompletableFuture<UserDTO> user = this.getUser(id);

        return user.thenCombineAsync(this.getPosts(id), UserPostsDTO::new);
    }

    private CompletableFuture<PostDTO[]> getPosts(final Long userId) {
        return CompletableFuture
                .supplyAsync(() -> restTemplate.getForObject(format(externalApiUrl + USER_POSTS_URL, userId), PostDTO[].class));

    }

    private CompletableFuture<UserDTO> getUser(final Long id) {
        return CompletableFuture
                .supplyAsync(() -> restTemplate.getForObject(externalApiUrl + USER_DATA_URL, UserDTO.class, id));
    }

}