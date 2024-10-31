package com.easybusan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusan.service.CoolSmsService;

import jakarta.servlet.http.HttpSession;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

import java.util.Map;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private CoolSmsService coolSmsService;

    @PostMapping("/send")
    public String sendSms(@RequestBody Map<String, String> body, HttpSession session) {
        String phoneNumber = body.get("phoneNumber");

        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return "Phone number is missing";
        }

        try {
           
            String generatedCode = coolSmsService.sendSms(phoneNumber);

            
            session.setAttribute("generatedCode", generatedCode);
            System.out.println("Generated code stored in session: " + generatedCode);

            return "Generated verification code: " + generatedCode;
        } catch (CoolsmsException e) {
            e.printStackTrace();
            return "Failed to send SMS: " + e.getMessage();
        }
    }
    @PostMapping("/verify")
    public String verifyCode(@RequestBody Map<String, String> body, HttpSession session) {
        String inputCode = body.get("authCode");  
        String sessionCode = (String) session.getAttribute("generatedCode");  

       
        if (sessionCode == null) {
            return "Session expired or code not found";  
        }

      
        if (sessionCode.equals(inputCode)) {
            return "Verification successful";  
        } else {
            return "Invalid verification code";  
        }
    }
}