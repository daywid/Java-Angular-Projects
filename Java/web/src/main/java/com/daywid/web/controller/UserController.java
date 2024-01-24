package com.daywid.web.controller;

import org.springframework.web.bind.annotation.RestController;
import com.daywid.web.entity.Users;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class UserController {
    
    @GetMapping("/users")
    public String getUser(Model model) {

        model.addAttribute("users", new Users());

        return "users";
    }
    
     @PostMapping("users")
     public String userSubmit(@ModelAttribute Users users) {
         return "result";
     }    
}
