package com.cofeeBin.web.dto.amount;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //모든 final 필드가 포함된 생성자 형성
public class AmountSaveRequestDto {

    private final String bin_name;
    private final int plastic_amount;
    private final int paper_amount;




}
