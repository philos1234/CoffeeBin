package com.cofeeBin.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppRequestDto {
    // 모든 요청
    private String token;

    public AppRequestDto(){};

}
