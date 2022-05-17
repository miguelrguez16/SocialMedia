package com.social.social.controllers;


import com.social.social.entities.Posts;
import com.social.social.entities.Users;
import com.social.social.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "api/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController (PostService postService){
        this.postService = postService;
    }

    @GetMapping //Method GET
    public List<Posts> getStudents() {
        System.out.println("geAllPost");
        return postService.getAllPosts();
    }

}
