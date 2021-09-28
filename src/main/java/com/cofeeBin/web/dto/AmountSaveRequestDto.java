package com.cofeeBin.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //모든 final 필드가 포함된 생성자 형성
public class AmountSaveRequestDto {

    private final String bin_name;
    private final Long plastic_amount;
    private final Long paper_amount;
    private final Long water_amount;




}
