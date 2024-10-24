package com.easybusan.repository.interfaces;

import com.easybusan.repository.model.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionRepository {

    // 현재 테스트에서 답변하지 않은 질문 1개 조회
    Question readQuestionByUserKindId(Integer userKindId);
}
