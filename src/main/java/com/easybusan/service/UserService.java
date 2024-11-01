package com.easybusan.service;

import java.util.HashMap;
import java.util.Map;

import com.easybusan.exception.errors.Exception400;
import com.easybusan.exception.errors.Exception401;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.easybusan.dto.UserDTO;
import com.easybusan.repository.interfaces.UserRepository;
import com.easybusan.repository.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    //이메일 중복체크
    public Map<String, String> checkFieldRepetition(UserDTO.joinDTO dto) {
    	Map<String, String> result = new HashMap<>();
        boolean repetition = false;
        
        if(dto.getEmail() != null){
            repetition = userRepository.checkEmail(dto.getEmail());
            if(repetition == true){
                result.put("repetition", "repetition");
            }
       }
        
        if (!dto.getEmail().contains("@")) {
            result.put("repetition", "emailFormatError");
        }

        return result;
    }
    
    //회원가입
    public int joinUser(UserDTO.joinDTO dto){
    	System.out.println(" @# joinUser dto ======> "+dto);
    	int result = 0;
        dto.setType("member"); 
    	
    	String hashPwd = passwordEncoder.encode(dto.getPassword());
		
    	dto.setPassword(hashPwd);
		
    	result =  userRepository.createUser(dto);
        User user = userRepository.findByEmail(dto.getEmail());
        int userId = user.getUserId();
        dto.setUserId(userId);
        userRepository.createUserDetail(dto);
		return result;
	} 

    //로그인 로직
    public User findUserByEmail(UserDTO.loginDTO dto){
        User user = userRepository.findByEmail(dto.getEmail());
        if (user == null) {
            throw new Exception400("존재하지 않는 계정입니다.");
        }

        if (passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return user; 
        } else {
            throw new Exception400("비밀번호가 일치하지않습니다.");
        }
  
    }
    

}
