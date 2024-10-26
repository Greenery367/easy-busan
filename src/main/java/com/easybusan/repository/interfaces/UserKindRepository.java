package com.easybusan.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserKindRepository {

    // userId로 현재 진행중인 테스트의 pk 조회
    Integer readUserKindIdByUserIdAndKindIdIsNull(int userId);

    // userId만 가지고 생성 -> 테스트 시작!
    int create(int userId);

    // 제일 최신의 userKind (KindId null이 아닌)
    Integer readUserKindIdByUserIdAndKindIdIsNotNull(int userId);

    Integer readUserKindIdByUserId(int userId);

    // kindId 업데이트
    void updateUserKindIdById(@Param(value = "id") int id, @Param(value = "kindId") int kindId);
}
