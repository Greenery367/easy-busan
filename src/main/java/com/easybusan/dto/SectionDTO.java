package com.easybusan.dto;

import lombok.Data;

public class SectionDTO {

    @Data
    public static class ScoreDTO {
        private int sectionId;
        private int score;
    }
}
