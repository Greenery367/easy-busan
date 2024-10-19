package com.easybusan.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class EstateAPIDTO {

    private Script script;
    private Header header;
    private Body body;

    @Data
    public static class Script {
        // 내용이 비어 있으므로, 별도 필드가 없습니다.
    }

    @Data
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }

    @Data
    public static class Body {
        @JacksonXmlElementWrapper(localName = "items")
        @JacksonXmlProperty(localName = "item")
        private List<Item> items;
        private int numOfRows;
        private int pageNo;
        private int totalCount;
    }

    @Data
    public static class Item {
        private String dealAmount;
        private double excluUseAr;
        private String deposit;
        private double monthlyRent;
        private double totalFloorAr;
    }
}

