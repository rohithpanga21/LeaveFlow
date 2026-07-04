package com.leaveflow.leaveflow.controller;

import com.leaveflow.leaveflow.model.User;
import com.leaveflow.leaveflow.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service){
        this.service=service;
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
         return service.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id ,@RequestBody User user){
        return service.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteUser(id);
    }

}
