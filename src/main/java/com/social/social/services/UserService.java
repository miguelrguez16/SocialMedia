package com.social.social.services;

import com.mongodb.client.MongoCollection;
import com.social.social.entities.Users;
import com.social.social.repositories.UserRepository;
import com.social.social.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.bson.types.ObjectId;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(Users user) {
        if(emailExists(user.getEmail())) throw new IllegalStateException("email already taken");
        if(user.getId()==null) user.setId(new ObjectId());
        System.out.println(user);
        user.setPassword(Util.getSHA256(user.getPassword()));
        userRepository.save(user);
    }

    public Boolean emailExists(String email){
        Optional<Users> usersEmail = userRepository.findUserByEmail(email);
        return usersEmail.isPresent();
    }
}
