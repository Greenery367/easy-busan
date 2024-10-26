package com.easybusan.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Kind {
	
	private Integer kindId;
	private String kindName;
	private String kindSGG;
	private String kindText;
	
}
