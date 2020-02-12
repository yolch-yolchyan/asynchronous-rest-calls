package com.coding.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserPostsDTO {

    private UserDTO user;

    private PostDTO[] posts;

}
