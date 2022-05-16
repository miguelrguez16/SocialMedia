package com.social.social.services;

import com.mongodb.client.MongoCollection;
import com.social.social.entities.Users;
import com.social.social.repositories.UserRepository;
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


    public List<Users> getStudents() {
        return userRepository.findAll();
    }

    public void addNewUser(Users user) {
        Optional<Users> usersOptional =
                userRepository.findUserByEmail(user.getEmail());
        if (usersOptional.isPresent()) throw new IllegalStateException("email already taken");

        /*Document userToSave = new Document("_id", new ObjectId());
            userToSave.append("name", user.getName());
            userToSave.append("last", user.getLast());
            userToSave.append("email", user.getEmail());
            userToSave.append("date",user.getDate());*/

        if(user.getId()==null) user.setId(new ObjectId());
        System.out.println(user);

        userRepository.save(user);
    }
}