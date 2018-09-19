package com.honeypotato.homemanager.controller;

import com.honeypotato.homemanager.model.User;
import com.honeypotato.homemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("{id}")
    public User queryById(@PathVariable int id) {
        return service.queryById(id);
    }

    @GetMapping
    public List<User> queryList() {
        return service.queryList();
    }
}
