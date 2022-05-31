package com.social.social.controllers;


import com.social.social.entities.Users;
import com.social.social.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "api/users")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping //Method GET
    public List<Users> getStudents() {
        System.out.println("["+ LocalDateTime.now() + "]: getStudents() ");
        return userService.getUsers();
    }

    @PostMapping//Method Post
    public void registerNewUser(@RequestBody Users user){
        System.out.println("["+ LocalDateTime.now() + "]: registerNewUser " + user);

        userService.addNewUser(user);
    }

    @RequestMapping(path="email")
    @PostMapping
    public String isNewEmail(@RequestBody String email){
        System.out.println("["+ LocalDateTime.now() + "]: emailNotExists " + email);
        if( userService.emailExists(email)){
            return "message: " + email;
        }else {
            return "message: OK";
        }
    }




}
