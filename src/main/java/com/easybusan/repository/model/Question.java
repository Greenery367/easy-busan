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
 * 질문 Model
 */
public class Question {
	private int questionId; // 질문 아이디
	private String questionText; // 질문 내용
	private int parentId;
	private int sectionId;
	private String tip;
	private Timestamp createdAt; // 생성 시간
	
}
