package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.model.User;
import com.leaveflow.leaveflow.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepo userRepo;
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    @Override
    public User saveUser(User u1) {
        return userRepo.save(u1);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(int id)  {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
    }

    @Override
    public User updateUser(int id, User u1) {
        User existingUser = userRepo.findById(id).orElse(null);
        if(existingUser != null){
            existingUser.setFirstName(u1.getFirstName());
            existingUser.setLastName(u1.getLastName());
            existingUser.setEmail(u1.getEmail());
            existingUser.setPassword(u1.getPassword());
            existingUser.setRole(u1.getRole());
            existingUser.setDepartment(u1.getDepartment());
            existingUser.setStatus(u1.getStatus());
            return userRepo.save(existingUser);
        }
        else {
            throw new RuntimeException("User Not Found");
        }
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }
}
