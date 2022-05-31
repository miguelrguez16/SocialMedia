package com.social.social.services;

import com.social.social.entities.Posts;
import com.social.social.entities.Users;
import com.social.social.repositories.PostRepository;
import com.social.social.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Posts> getAllPosts() {
        return postRepository.findAll();
    }


    public void addNewPost(Posts post) {
        Optional<Users> usersOptional =
                userRepository.findUserByEmail(post.getEmailUser());
        if (usersOptional.isPresent())
            post.setId(new ObjectId());
            System.out.println(post.getEmailUser());
            postRepository.save(post);
    }

    public Posts getPostFromUser(String username) {
        Optional<Users> usersOptional =userRepository.findUserByUserName(username);
        Posts p =
                new Posts(new ObjectId(), "PRUEBAS", "PRUEBAS","PRUEBAS", LocalDate.of(2022,04,03));
        return p;
    }
}
