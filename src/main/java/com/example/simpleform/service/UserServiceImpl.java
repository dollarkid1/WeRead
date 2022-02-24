package com.example.simpleform.service;

import com.example.simpleform.model.AppUser;
import com.example.simpleform.model.dto.AppUserDto;
import com.example.simpleform.repository.UserRepository;
import com.example.simpleform.web.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;




    public AppUser authenticate(String login, String password){
        return userRepository
                .findByLoginAndPassword(login,
                        password).orElse(null);
    }

    @Override
    public AppUser registerUser(String login, String password, String email) throws UserNotFoundException {
        if (login == null && password == null){
            throw new UserNotFoundException("Invalid Login details");
        }
        else {
            AppUser appUser = new AppUser();
            appUser.setLogin(appUser.getLogin());
            appUser.setPassword(appUser.getPassword());
            appUser.setEmail(appUser.getEmail());
            return userRepository.save(appUser);
        }
    }

}
