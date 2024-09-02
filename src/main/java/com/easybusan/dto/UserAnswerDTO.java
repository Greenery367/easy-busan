package com.easybusan.dto;

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
 * 사용자 답변 DTO 
 */
public class UserAnswerDTO {

	private int userAnswerId; // 사용자 답변 아이디
	private int userId;
	private int answerId;
	private Timestamp createdAt; // 생성 시간
	
}
