package com.easybusan.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.easybusan.repository.model.KindRank;

@Mapper
public interface KindRankRepository {

    // 섹션 리스트에 해당하는 kindRank 조회
    List<KindRank> readKindRanksBySectionIds(@Param(value = "sectionIds") List<Integer> sectionIds);
    


}
