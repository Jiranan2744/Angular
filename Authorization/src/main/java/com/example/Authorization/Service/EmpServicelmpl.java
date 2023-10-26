package com.example.Authorization.Service;

import com.example.Authorization.Entity.User;
import com.example.Authorization.Repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServicelmpl implements EmpService {

    @Autowired
    private EmpRepo empRepo;

    @Override
    public User createUser(User user) {
        return empRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) empRepo.findAll();
    }

    @Override
    public User getUserById(int id) {
        return empRepo.findById(id).get();
    }

    @Override
    public void deleteUser(int id) {
        empRepo.deleteById(id);
    }

    @Override
    public User updateUser(User user, int id) {
        User user1 = empRepo.findById(id).get();
        user1.setEmail(user.getEmail());
        user1.setFirstname(user.getFirstname());
        user1.setLastname(user.getLastname());
        user1.setPassword(user.getPassword());

        return empRepo.save(user1);
    }

}
