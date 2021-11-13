package com.cofeeBin.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AppRequestDto {
    // 모든 요청
    private final String token;

    public AppRequestDto(){
    };

}
