package com.coding.challenge.service;

import com.coding.challenge.dto.PostDTO;
import com.coding.challenge.dto.UserDTO;
import com.coding.challenge.dto.UserPostsDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceAsyncTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void testIfAsync() throws Exception {
        ReflectionTestUtils.setField(userService, "externalApiUrl", "");
        ReflectionTestUtils.setField(userService, "externalApiUrl", "");

        final long userId = 1;

        when(restTemplate.getForObject("users/{id}", UserDTO.class, userId)).thenReturn(new UserDTO());
        when(restTemplate.getForObject("posts?userId=" + userId, PostDTO[].class)).thenReturn(new PostDTO[0]);


        CompletableFuture<UserPostsDTO> completableFuture = userService.getUserDataById(userId);
        assertFalse(completableFuture.isDone());

        UserPostsDTO userPosts = completableFuture.get();
        assertNotNull(userPosts);
        assertNotNull(userPosts.getPosts());
        assertNotNull(userPosts.getUser());

        assertTrue(completableFuture.isDone());
    }

}

