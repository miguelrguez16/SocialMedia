package com.social.social.controllers;


import com.social.social.entities.Posts;
import com.social.social.entities.Users;
import com.social.social.services.PostService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        System.out.println("["+ System.currentTimeMillis() + "]: getAllPost");
        return postService.getAllPosts();
    }
    @PostMapping(produces = "application/json")
    public void registerNewPost(@RequestBody Posts post){
        System.out.println("["+ LocalDateTime.now() + "]: registerNewPost " + post);
        postService.addNewPost(post);
    }

    // Get post usuario
    @GetMapping(params = "{userId})")
    public Posts getPostUser(@PathVariable("username") String username){
        System.out.println("["+ LocalDateTime.now() + "]: getPostUser " + username);
        return postService.getPostFromUser(username);
    }

    // Get post 10 más recientes



}
