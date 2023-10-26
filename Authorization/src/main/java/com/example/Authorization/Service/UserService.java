package com.example.Authorization.Service;

import com.example.Authorization.DTO.LoginDTO;
import com.example.Authorization.DTO.UserDTO;
import com.example.Authorization.Response.LoginMessage;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String addUser(UserDTO userDTO);

    LoginMessage loginUser(LoginDTO loginDTO);
    
}
