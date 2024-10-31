package com.easybusan.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easybusan.dto.UserDTO;
import com.easybusan.repository.model.User;
import com.easybusan.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
    private final HttpSession session;
    private final UserService userService;
	
    
    
    
    // 로그인 폼
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
    
    //로그인
    @PostMapping("/login")
    public String login(HttpSession session, UserDTO.loginDTO dto){

        User principal = userService.findUserByEmail(dto);
   
        System.out.println(dto); 
        System.out.println(principal);
        
        if(principal != null){
            session.setAttribute("principal", principal);
            return "redirect:/main";
        } else{
            return "redirect:/";
        }
       
    }
    
    //로그아웃
    @GetMapping("/logout")
    public String logout(){
	    session.invalidate();
	    return "redirect:/";
    }
    
    //회원가입
    @GetMapping("/join")
    public String joinForm() {
        return "join";
    }
    
    //중복확인
    @PostMapping("/checkUserEmail")
    public ResponseEntity<Map<String, String>> checkUserEmail(@RequestBody UserDTO.joinDTO dto) {

        Map<String, String > repetitionResult = userService.checkFieldRepetition(dto);
        return ResponseEntity.ok(repetitionResult);
    }
    
    //회원가입
    @PostMapping("/join")
    public String joinUser(@ModelAttribute UserDTO.joinDTO dto) {
        System.out.println("@# Received ====> " + dto);
        int result = userService.joinUser(dto);
        if (result > 0) {
            return "redirect:/user/login";
        } else {
            return "join";  
        }
    }
    
}
