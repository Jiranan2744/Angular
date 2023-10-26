package com.example.Authorization.Service;

import com.example.Authorization.DTO.LoginDTO;
import com.example.Authorization.DTO.UserDTO;
import com.example.Authorization.Entity.User;
import com.example.Authorization.Repo.EmpRepo;
import com.example.Authorization.Response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getId(),
                userDTO.getFirstname(),
                userDTO.getLastname(),
                userDTO.getEmail(),

                this.passwordEncoder.encode(userDTO.getPassword())
        );
        empRepo.save(user);

        return user.getFirstname();
    }

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = empRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null){
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight){
                Optional<User> user = empRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                   return new LoginMessage("Login Successfully!", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("Password Not Match", false);
            }
        } else {
            return new LoginMessage("Email not exits", false);
        }
    }
}

