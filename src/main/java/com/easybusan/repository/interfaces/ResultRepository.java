package com.easybusan.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

import com.easybusan.repository.model.Kind;

@Mapper
public interface ResultRepository {
	
	Kind readKindByUserId(int userId);
	
}
