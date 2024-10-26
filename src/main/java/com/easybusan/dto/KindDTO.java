package com.easybusan.dto;

import com.easybusan.repository.model.Kind;
import lombok.Builder;
import lombok.Data;

public class KindDTO {

    @Builder
    @Data
    public static class ResponseDTO {
        private String kindName;
        private String kindSGG;
        private String kindText;

        public static ResponseDTO of(Kind kind) {
            return ResponseDTO.builder()
                    .kindName(kind.getKindName())
                    .kindText(kind.getKindText())
                    .kindSGG(kind.getKindSGG())
                    .build();
        }
    }

}
