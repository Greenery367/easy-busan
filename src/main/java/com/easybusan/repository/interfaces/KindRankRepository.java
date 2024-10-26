package com.easybusan.repository.interfaces;

import com.easybusan.repository.model.KindRank;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KindRankRepository {

    // 섹션 리스트에 해당하는 kindRank 조회
    List<KindRank> readKindRanksBySectionIds(List<Integer> sectionIds);

}
