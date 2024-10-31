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
 *  
 */
public class section {

	private int sectionId; 
	private String sectionName;
	private Timestamp createdAt; // 생성 시간
	
}
