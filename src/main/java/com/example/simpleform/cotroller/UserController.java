package com.example.simpleform.cotroller;

import com.example.simpleform.model.AppUser;
import com.example.simpleform.service.UserService;
import com.example.simpleform.web.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.PostLoad;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new AppUser());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new AppUser());
        return "login_page";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute AppUser appUser) throws UserNotFoundException {
        System.out.println("register request: " + appUser);
        AppUser registeredUser = userService.registerUser(appUser.getLogin(),
                appUser.getPassword(), appUser.getEmail());

        return registeredUser == null ? "error_page" : "redirect:/login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute AppUser appUser, Model model) throws UserNotFoundException {
        System.out.println("login request: " + appUser);
        AppUser authenticated = userService.authenticate(appUser.getLogin(), appUser.getPassword());

        if (authenticated != null){
            model.addAttribute("userLogin", authenticated.getLogin());
            return "home_page";
        }else {
            return "error_page";
        }
    }

}
