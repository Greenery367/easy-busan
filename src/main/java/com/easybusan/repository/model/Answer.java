package com.easybusan.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private Integer answerId;
    private Integer questionId;
    private String answerText;
    private Timestamp createdAt;
}
