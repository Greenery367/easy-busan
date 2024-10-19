package com.easybusan.repository.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
public class BusStopResponse {

    private Header header;
    
    private Body body;

    // Getters and Setters

    @Data
    public static class Header {
        private String resultCode;
        private String resultMsg;

        // Getters and Setters
    }

    @Data
    public static class Body {
        @JacksonXmlElementWrapper(localName="items")
        @JacksonXmlProperty(localName="item")
        private List<Item> items;
        private int numOfRows;
        private int pageNo;
        private int totalCount;

        @Data
    
        public static class Item {
            private String bstopid;
            private String bstopnm;
            private String arsno;
            private String gpsx;
            private String gpsy;
            private String stoptype;
        }
    }
}
