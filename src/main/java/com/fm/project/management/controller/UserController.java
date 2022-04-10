package com.fm.project.management.controller;

import com.fm.project.management.exceptions.ResourceAlreadyExistsException;
import com.fm.project.management.model.User;
import com.fm.project.management.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register/add")
    public String registerUser(Model model, @ModelAttribute @Valid User user) {
        try{
            userService.save(user);
        }catch (ResourceAlreadyExistsException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "user/register";
        }
        return "redirect:/login";
    }

    @GetMapping("/admin")
    public String showAdminPage() {
        return "admin";
    }

    @GetMapping("/user")
    public String showUserPage() {
        return "user";
    }
}
