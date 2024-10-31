package com.easybusan.service;
import java.util.Random;
import org.apache.struts.action.ExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import net.nurigo.java_sdk.api.Message; // CoolSMS Message 클래스
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class CoolSmsService {

    @Value("${coolsms.api.key}")
    private String apiKey;

    @Value("${coolsms.api.secret}")
    private String apiSecret;

    @Value("${coolsms.api.number}")
    private String fromPhoneNumber;

    public String sendSms(String to) throws CoolsmsException {
        try {
           
            String numStr = generateRandomNumber();

            Message coolsms = new Message(apiKey, apiSecret);

            HashMap<String, String> params = new HashMap<>();
            params.put("to", to);    
            params.put("from", fromPhoneNumber); 
            params.put("type", "sms");
            params.put("text", "인증번호는 [" + numStr + "] 입니다.");

            
            coolsms.send(params);

            return numStr; 

        } catch (Exception e) {
            new ExceptionHandler();
        }
        return null;
    }

    
    private String generateRandomNumber() {
        Random rand = new Random();
        StringBuilder numStr = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            numStr.append(rand.nextInt(10));
        }
        return numStr.toString();
    }
}