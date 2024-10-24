package com.easybusan.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserKindRepository {

    // userId로 현재 진행중인 테스트의 pk 조회
    Integer readUserKindIdByUserIdAndKindIdIsNull(int userId);

    // userId만 가지고 생성 -> 테스트 시작!
    int create(int userId);
}
