package com.example.secureApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        return "home";  // home.html will be returned
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // login.html page
    }

    @PostMapping("/submit")
    public String submit(@RequestParam String message, Model model) {
        model.addAttribute("message", message);
        return "home";  // Returning back to home.html with submitted message
    }
}
