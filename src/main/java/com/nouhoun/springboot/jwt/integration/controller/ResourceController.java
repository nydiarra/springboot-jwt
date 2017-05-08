package com.nouhoun.springboot.jwt.integration.controller;

import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nydiarra on 06/05/17.
 */
@RestController
@RequestMapping("/api")
public class ResourceController {
    @Autowired
    private UserService userService;

    @RequestMapping(value ="/user/{username}", method = RequestMethod.GET)
    @PreAuthorize("#username == authentication.name")
    public User getUser(@PathVariable("username") String username){
        return userService.findByUsername(username);
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN_USER')")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }
}
