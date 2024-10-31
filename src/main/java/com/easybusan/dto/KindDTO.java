package com.easybusan.dto;

import com.easybusan.repository.model.Kind;
import com.easybusan.repository.model.SectionCategory;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public class KindDTO {

    @Builder
    @Data
    public static class ResponseDTO {
        private String kindName;
        private String kindSGG;
        private String kindText;
        private List<SectionCategory> sectionCategoryList;
        private boolean noResult;

        public static ResponseDTO of(Kind kind, List<SectionCategory> sectionCategoryList) {
            return ResponseDTO.builder()
                    .kindName(kind.getKindName())
                    .kindText(kind.getKindText())
                    .kindSGG(kind.getKindSGG())
                    .sectionCategoryList(sectionCategoryList)
                    .build();
        }
    }

}
