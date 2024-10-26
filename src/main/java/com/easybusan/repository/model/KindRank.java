package com.easybusan.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KindRank {
    private Integer kindRankId;
    private Integer kindId;
    private Integer sectionId;
    private Integer rank;
    private Timestamp createdAt;

    public int calculateScore(int score) {
        // 1,2등 - 8점 / 3,4등 - 7점 ... 15,16등 1점
        int factor = (16 - rank) / 2 + 1;
        return factor * score;
    }
}
