package com.example.simpleform.service;

import com.example.simpleform.model.AppUser;
import com.example.simpleform.model.dto.AppUserDto;
import com.example.simpleform.web.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;


public interface UserService {

    

    public AppUser authenticate(String login, String password);

    AppUser registerUser(String login, String password, String email) throws UserNotFoundException;
}
