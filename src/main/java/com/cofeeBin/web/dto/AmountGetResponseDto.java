package com.cofeeBin.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //모든 final 필드가 포함된 생성자 형성
public class AmountGetResponseDto {

    private final String plastic_amount;
    private final String paper_amount;
}
