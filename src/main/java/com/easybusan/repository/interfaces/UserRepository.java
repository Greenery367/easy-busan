package com.easybusan.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

import com.easybusan.dto.UserDTO;
import com.easybusan.repository.model.User;

@Mapper
public interface UserRepository {
    // 회원 가입
    public int createUser(UserDTO.joinDTO dto);
    //  아이디 중복확인
    public boolean checkEmail(String email);
    // 로그인
    public User loginByUserIdandPassword(UserDTO.loginDTO dto);
    // 아이디로 로그인
    public User findByEmail(String email);
}
