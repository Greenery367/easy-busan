package com.easybusan.service;

import com.easybusan.dto.EstateAPIDTO;
import com.easybusan.utils.APIDefine;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EstateRankService {

    public Map<String, Integer> rankCalculate(Map<String, Double> sortedMap){
        AtomicInteger rank = new AtomicInteger(sortedMap.size()); // rank를 AtomicInteger로 변경하여 값 수정 가능
        Map<String, Integer> rankMap = new HashMap<>();

        sortedMap.forEach((k, v) -> {
            rankMap.put(nameConverter(k), rank.getAndDecrement());
        });
        return rankMap;
    }

    public String nameConverter(String code){
        if (code.equals(APIDefine.GANGSEOGU)) return "강서구";
        else if (code.equals(APIDefine.GEUMJEONGGU)) return "금정구";
        else if (code.equals(APIDefine.GIJANGGUN)) return "기장군";
        else if (code.equals(APIDefine.NAMGU)) return "남구";
        else if (code.equals(APIDefine.DONGGU)) return "동구";
        else if (code.equals(APIDefine.DONGNAEGU)) return "동래구";
        else if (code.equals(APIDefine.BUSANJINGU)) return "부산진구";
        else if (code.equals(APIDefine.BUKGU)) return "북구";
        else if (code.equals(APIDefine.SASANGGU)) return "사상구";
        else if (code.equals(APIDefine.SAHAGU)) return "사하구";
        else if (code.equals(APIDefine.SEOGU)) return "서구";
        else if (code.equals(APIDefine.SUYEONGGU)) return "수영구";
        else if (code.equals(APIDefine.YEONJEGU)) return "연제구";
        else if (code.equals(APIDefine.YEONGDOGU)) return "영도구";
        else if (code.equals(APIDefine.JUNGGU)) return "중구";
        else if (code.equals(APIDefine.HAEUNDAEGU)) return "해운대구";
        return code;
    }
}
