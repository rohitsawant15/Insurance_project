package com.insu.iworkshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.insu.iworkshop.config.CustomUserDetails;
import com.insu.iworkshop.entities.User;
import com.insu.iworkshop.repo.UserRepo;



@Controller
public class AppController {
 
    @Autowired
    private UserRepo userRepo;
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
         
        return "signup_form";
    }
    
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
         
        userRepo.save(user);
         
        return "register_success";
    }
    
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
        
        CustomUserDetails details =(CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(details.getUserID());
        long id = details.getUserID();

        //Admin Id
        if(id==1) {return "adminlist";}
        return "users";
    }
}
