package com.example.Authorization.Controller;

import com.example.Authorization.DTO.LoginDTO;
import com.example.Authorization.DTO.UserDTO;
import com.example.Authorization.Entity.GroupEntity;
import com.example.Authorization.Entity.User;
import com.example.Authorization.Response.LoginMessage;
import com.example.Authorization.Service.EmpService;
import com.example.Authorization.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private UserService userService;

    // Rest API Crud - Create - POST
    // Read - GET
    // Delete - DELETE
    // Update - PUT

    // create user
    @PostMapping("/add")
    public User createUser(@RequestBody User user){
        User user1 = empService.createUser(user);
        return user1;
    }

    // Create signup
    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO)
    {
        String id = userService.addUser(userDTO);
        return id;
    }

    // Get login
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginMessage loginMessage = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }

    // Read user all
    @GetMapping("/get")
    public List<User> getUsers(){
        return empService.getUsers();
    }

    // Read user id
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") int id){
        return empService.getUserById(id);
    }

    // Update user
    @PutMapping("/update/{id}")
    public User updateUserById(@RequestBody User user, @PathVariable("id") int id){
       return empService.updateUser(user, id);
    }

    // Delete user
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        empService.deleteUser(id);
        return "User Delete Successfully";
    }

}