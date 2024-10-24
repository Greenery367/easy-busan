package com.easybusan.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.easybusan.repository.model.Kind;
import com.easybusan.repository.model.Section;

@Mapper
public interface ResultRepository {
	
	Kind readKindByUserId(int userId);
	
	List<Section> readSectionsByUserId(int userId);
}
