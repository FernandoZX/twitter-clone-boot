package com.koombea.twitterclone.twitterclone.controllers;


import com.koombea.twitterclone.twitterclone.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController extends BaseController{

    private UserServiceImpl userService;

    // user login
    @GetMapping("/sign_in")
    public String sign_in(){
        return "sign_in";
    }


    // user registration
    @GetMapping("/sign_up")
    public String sign_up(){
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String sign_up_create(){
        return "sign_up";
    }
}
