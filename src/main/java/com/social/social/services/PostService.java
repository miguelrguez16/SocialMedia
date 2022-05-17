package com.social.social.services;

import com.social.social.entities.Posts;
import com.social.social.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Posts> getAllPosts() {
        return postRepository.findAll();
    }

}
