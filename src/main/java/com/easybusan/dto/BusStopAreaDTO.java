package com.easybusan.dto;
import java.util.List;

import lombok.Data;

@Data
public class BusStopAreaDTO {
    private List<Result> resultList;
    
    @Data
    public class Result{
        private String sggCd;
        private String emdongCd;
        private String fullAddr;
        private String sidoNm;
        private String emdongNm;
        private String totRegCd;
        private String sidoCd;
    }
}
