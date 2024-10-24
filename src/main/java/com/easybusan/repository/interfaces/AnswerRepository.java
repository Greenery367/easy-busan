package com.easybusan.repository.interfaces;

import com.easybusan.repository.model.Answer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnswerRepository {

    // 질문 id로 답변 조회
    List<Answer> findAnswersByQuestionId(Integer questionId);
}
