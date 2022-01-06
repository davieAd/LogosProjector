package com.example.logosproject.controller;

import com.example.logosproject.models.User;
import com.example.logosproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new User());
        return "main_page";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
               userRepository.save(user);
               return "register_success";
    }

    @GetMapping("/users")
    public String viewUserList(Model model){
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @RequestMapping("/deleteData")
    public String deleteUser(@RequestParam("id") Long id){
        userRepository.deleteById(id);

        ModelAndView mv = new ModelAndView();

        List<User> userList = userRepository.findAll();

        mv.addObject("data",userList);
        mv.setViewName("view");

        return "index";
    }



}
