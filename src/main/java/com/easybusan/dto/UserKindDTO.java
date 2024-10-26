package com.easybusan.dto;

import lombok.Getter;

import java.util.List;

public class UserKindDTO {

    @Getter
    public static class UpdateDTO {
        private List<Integer> ids;
    }
}
