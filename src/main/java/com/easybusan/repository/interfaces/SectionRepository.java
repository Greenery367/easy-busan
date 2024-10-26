package com.easybusan.repository.interfaces;

import com.easybusan.dto.SectionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SectionRepository {

    List<SectionDTO.ScoreDTO> readSectionScoreBySectionIds(@Param(value = "userId") Integer userId, @Param(value = "sectionCateList") List<Integer> sectionCateList);
}
