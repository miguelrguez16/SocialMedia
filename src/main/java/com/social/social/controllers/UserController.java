package com.social.social.controllers;


import com.social.social.entities.Users;
import com.social.social.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/users")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping //Method GET
    public List<Users> getStudents() {
        return userService.getStudents();
    }

    @PostMapping//Method Post
    public void registerNewStudent(@RequestBody Users user){
        System.out.println(user);

        userService.addNewUser(user);
    }




}
