package com.easybusan.repository.model;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
