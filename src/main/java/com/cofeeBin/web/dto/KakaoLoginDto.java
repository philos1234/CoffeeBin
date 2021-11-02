package com.cofeeBin.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //모든 final 필드가 포함된 생성자 형성
public class KakaoLoginDto {

    private final String phoneNum;
    private final String SerialNum;



}
