package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User saveUser(User u1);
    List<User> getAllUsers();
    User getUserById(int id);
    User updateUser(int id,User u1);
    void deleteUser(int id);
}
