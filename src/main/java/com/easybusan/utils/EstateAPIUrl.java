package com.easybusan.utils;

import java.util.HashMap;
import java.util.Map;

public class EstateAPIUrl {

    // 부동산 관련 api url
    public static final String APT_TRADE = "http://apis.data.go.kr/1613000/RTMSDataSvcAptTrade/getRTMSDataSvcAptTrade";
    public static final String APT_RENT = "http://apis.data.go.kr/1613000/RTMSDataSvcAptRent/getRTMSDataSvcAptRent";
    public static final String RH_TRADE = "http://apis.data.go.kr/1613000/RTMSDataSvcRHTrade/getRTMSDataSvcRHTrade";
    public static final String RH_RENT = "http://apis.data.go.kr/1613000/RTMSDataSvcRHRent/getRTMSDataSvcRHRent";
    public static final String OFFI_TRADE = "http://apis.data.go.kr/1613000/RTMSDataSvcOffiTrade/getRTMSDataSvcOffiTrade";
    public static final String OFFI_RENT = "http://apis.data.go.kr/1613000/RTMSDataSvcOffiRent/getRTMSDataSvcOffiRent";
    public static final String SH_TRADE = "http://apis.data.go.kr/1613000/RTMSDataSvcSHTrade/getRTMSDataSvcSHTrade";
    public static final String SH_RENT = "http://apis.data.go.kr/1613000/RTMSDataSvcSHRent/getRTMSDataSvcSHRent";
    public static final Map<String, String> MAP = new HashMap();
    static {
        MAP.put("APT_TRADE", APT_TRADE);
        MAP.put("APT_RENT", APT_RENT);
        MAP.put("RH_TRADE", RH_TRADE);
        MAP.put("RH_RENT", RH_RENT);
        MAP.put("OFFI_TRADE", OFFI_TRADE);
        MAP.put("OFFI_RENT", OFFI_RENT);
        MAP.put("SH_TRADE", SH_TRADE);
        MAP.put("SH_RENT", SH_RENT);
    }
}
