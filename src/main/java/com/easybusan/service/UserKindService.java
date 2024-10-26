package com.easybusan.service;

import com.easybusan.dto.KindDTO;
import com.easybusan.dto.SectionDTO;
import com.easybusan.dto.UserKindDTO;
import com.easybusan.repository.interfaces.KindRankRepository;
import com.easybusan.repository.interfaces.KindRepository;
import com.easybusan.repository.interfaces.SectionRepository;
import com.easybusan.repository.interfaces.UserKindRepository;
import com.easybusan.repository.model.KindRank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;

@Service
@RequiredArgsConstructor
public class UserKindService {

    private final UserKindRepository userKindRepository;
    private final SectionRepository sectionRepository;
    private final KindRankRepository kindRankRepository;
    private final KindRepository kindRepository;

    @Transactional
    public KindDTO.ResponseDTO getUserKind(UserKindDTO.UpdateDTO reqDTO, Integer userId) {
        try {
            // 1. 제일 최신의 userKind 조회
            Integer userKindId = userKindRepository.readUserKindIdByUserId(userId);
            if (userKindId == null) {
                // TODO 에러 페이지
                return null;
            }
            // 2. 필터 걸린 섹션 별 점수 추출
            List<SectionDTO.ScoreDTO> scoreList = sectionRepository.readSectionScoreBySectionIds(userId, reqDTO.getIds());
            // 3. 해당 섹션들의 kind 별 등수 추출
            List<Integer> sectionList = scoreList.stream().map(SectionDTO.ScoreDTO::getSectionId).toList();
            List<KindRank> kindRankList = kindRankRepository.readKindRanksBySectionIds(sectionList);
            // 4. 등수와 점수를 매치시켜 kind 총점수 1등을 조회 후 리턴
            // <kindId, 점수>
            Map<Integer, Integer> sumMap = kindRankList.stream()
                    .flatMap(kindRank -> scoreList.stream()
                            .filter(scoreDTO -> kindRank.getSectionId().equals(scoreDTO.getSectionId()))
                            .map(scoreDTO -> new AbstractMap.SimpleEntry<>(kindRank.getKindId(), kindRank.calculateScore(scoreDTO.getScore())))
                    )
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            Integer::sum
                    ));
            System.out.println(sumMap);
            Integer kindId = sumMap.entrySet().stream()
                    .max(Comparator.comparing(Entry::getValue))
                    .map(Entry::getKey)
                    .orElse(null);
            userKindRepository.updateUserKindIdById(userKindId, kindId);
            return KindDTO.ResponseDTO.of(kindRepository.readKindById(kindId));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
