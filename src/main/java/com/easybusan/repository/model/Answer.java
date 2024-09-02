package com.easybusan.repository.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
/**
 * 답변 Model
 */
public class Answer {

	private int answerId; // 답변 아이디
	private int questionId; 
	private int sectionId; 
	private String answerText;
	private int score;
	private Timestamp createdAt; // 생성 시간
	
}
