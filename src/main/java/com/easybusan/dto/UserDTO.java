package com.easybusan.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id; // (pk) auto_increment
    private String email;
    private String password;
    private String type; // member, unknown, manager
    private Integer age;
    private String gender;
    private String activeStatus;
    private Timestamp createdAt;
    private String phoneNumber;
    
    //회원가입DTO
    @Data
    public static class joinDTO{
    	private Integer userId;
        private String email;
        private String password;
        private String user_name;
        private String phoneNumber;
        private Integer age;
        private String gender;
        private String type;
    }
    
    //로그인DTO
    @Data
    public static class loginDTO{
        private String email;
        private String password;
    }

    
}
