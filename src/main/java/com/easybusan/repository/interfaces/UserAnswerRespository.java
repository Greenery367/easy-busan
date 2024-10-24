package com.easybusan.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserAnswerRespository {

    // 유저 응답 등록
    int createUserAnswer(@Param(value = "userId") Integer userId, @Param(value = "answerId") Integer answerId, @Param(value = "userKindId") Integer userKindId);
}
