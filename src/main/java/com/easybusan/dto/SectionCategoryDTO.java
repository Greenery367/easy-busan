package com.easybusan.dto;

import com.easybusan.repository.model.SectionCategory;
import lombok.Data;

public class SectionCategoryDTO {

    @Data
    public static class ResponseDTO {
        private int sectionCategoryId;
        private String sectionCategoryName;

        public ResponseDTO(SectionCategory sectionCategory) {
            this.sectionCategoryId = sectionCategory.getSectionCategoryId();
            this.sectionCategoryName = sectionCategory.getSectionCategoryName();
        }
    }
}
