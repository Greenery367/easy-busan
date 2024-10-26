package com.easybusan.dto;

import com.easybusan.repository.model.Answer;
import com.easybusan.repository.model.Question;
import com.easybusan.repository.model.SectionCategory;
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
        private List<SectionCategoryDTO.ResponseDTO> sectionCategoryList;

        public static ResponseDTO of(Question question, List<Answer> answerList) {
            return ResponseDTO.builder()
                    .questionText(question.getQuestionText())
                    .tip(question.getTip())
                    .newTest(true)
                    .last(false)
                    .answerList(answerList.stream()
                            .map(AnswerDTO.ResponseDTO::new)
                            .toList())
                    .build();
        }

        public static ResponseDTO of(List<SectionCategory> sectionCategoryList) {
            return ResponseDTO.builder()
                    .sectionCategoryList(sectionCategoryList.stream()
                            .map(SectionCategoryDTO.ResponseDTO::new)
                            .toList())
                    .newTest(true)
                    .last(true)
                    .build();
        }
    }
}
