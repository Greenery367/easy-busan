package com.easybusan.repository.interfaces;

import com.easybusan.repository.model.SectionCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SectionCategoryRepository {

    // 모든 섹션 카테고리 조회
    List<SectionCategory> readAll();
}
