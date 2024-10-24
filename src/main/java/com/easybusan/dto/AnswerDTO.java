package com.easybusan.dto;

import com.easybusan.repository.model.Answer;
import lombok.Data;
import lombok.ToString;

public class AnswerDTO {

    @Data
    public static class ResponseDTO {
        private int answerId;
        private String answerText;

        public ResponseDTO(Answer answer) {
            this.answerId = answer.getAnswerId();
            this.answerText = answer.getAnswerText();
        }
    }
}
