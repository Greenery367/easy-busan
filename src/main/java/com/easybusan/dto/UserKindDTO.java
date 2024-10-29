package com.easybusan.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class UserKindDTO {

    @Getter
    @ToString
    public static class UpdateDTO {
        private List<Integer> ids;
    }
}
