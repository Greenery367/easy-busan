package com.easybusan.utils;

public class APIUrl {

    // 부동산 관련 api url
    public static final String REAL_ESTATE_TYPE_COUNT = "https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json";
    public static final String REAL_ESTATE_APT_TRADE = "http://apis.data.go.kr/1613000/RTMSDataSvcAptTrade/getRTMSDataSvcAptTrade";
    public static final String REAL_ESTATE_APT_RENT = "http://apis.data.go.kr/1613000/RTMSDataSvcAptTrade/getRTMSDataSvcAptTrade";
    public static final String REAL_ESTATE_RH_TRADE = "http://apis.data.go.kr/1613000/RTMSDataSvcRHTrade/getRTMSDataSvcRHTrade";
    public static final String REAL_ESTATE_RH_RENT = "http://apis.data.go.kr/1613000/RTMSDataSvcRHRent/getRTMSDataSvcRHRent";
    public static final String REAL_ESTATE_OFFI_TRADE = "http://apis.data.go.kr/1613000/RTMSDataSvcOffiTrade/getRTMSDataSvcOffiTrade";
    public static final String REAL_ESTATE_OFFI_RENT = "http://apis.data.go.kr/1613000/RTMSDataSvcOffiRent/getRTMSDataSvcOffiRent";
    public static final String REAL_ESTATE_SH_TRADE = "http://apis.data.go.kr/1613000/RTMSDataSvcSHTrade/getRTMSDataSvcSHTrade";
    public static final String REAL_ESTATE_SH_RENT = "http://apis.data.go.kr/1613000/RTMSDataSvcSHRent/getRTMSDataSvcSHRent";
    public static final String[] REAL_ESTATE_LIST = new String[]{
            REAL_ESTATE_APT_TRADE,
            REAL_ESTATE_APT_RENT,
            REAL_ESTATE_RH_TRADE,
            REAL_ESTATE_RH_RENT,
            REAL_ESTATE_OFFI_TRADE,
            REAL_ESTATE_OFFI_RENT,
            REAL_ESTATE_SH_TRADE,
            REAL_ESTATE_SH_RENT,
    };
}
