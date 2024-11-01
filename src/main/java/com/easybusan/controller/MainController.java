package com.easybusan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.easybusan.repository.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(HttpSession session, Model model) {
        User sessionUser = (User)session.getAttribute("sessionUser");
        if (sessionUser != null) {
            model.addAttribute("sessionUser", sessionUser);
        }
        return  "index";
    }
    

}
