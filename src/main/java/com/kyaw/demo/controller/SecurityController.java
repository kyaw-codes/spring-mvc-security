package com.kyaw.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("tagline", "Hello Spring Security!");
        return "user/home";
    }

    @GetMapping("/admin/delete")
    public String deletePost(Model model) {
        model.addAttribute("message", "You are admin and you delete the post");
        return "admin/delete";
    }

    @GetMapping("/user/posts")
    public String showAllPost(Model model) {
        model.addAttribute("message", "Show All Posts");
        return "user/post";
    }
}
