package com.easybusan.dto;

import com.easybusan.repository.model.Answer;
import com.easybusan.repository.model.Question;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public class UserKindTestDTO {

    @Data
    @Builder
    public static class ResponseDTO {

        private String questionText;
        private String tip;
        private List<AnswerDTO.ResponseDTO> answerList;
        private boolean newTest;
        private boolean last;

        public static ResponseDTO of(Question question, List<Answer> answerList) {
            return ResponseDTO.builder()
                    .questionText(question.getQuestionText())
                    .tip(question.getTip())
                    .newTest(true)
                    .last(false)
                    .answerList(answerList.stream()
                            .map(AnswerDTO.ResponseDTO::new)
                            .collect(Collectors.toList()))
                    .build();
        }

    }
}
