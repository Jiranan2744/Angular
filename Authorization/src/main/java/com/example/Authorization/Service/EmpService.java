package com.example.Authorization.Service;

import com.example.Authorization.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpService {

    // create user
    public User createUser(User user);

    // read user
    public List<User> getUsers();

    // read user by ID
    public User getUserById(int id);

    // delete user
    public void deleteUser(int id);

    // update user
    public User updateUser(User user, int id);

}
