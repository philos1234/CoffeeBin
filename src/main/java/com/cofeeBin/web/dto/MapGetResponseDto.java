package com.cofeeBin.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class MapGetResponseDto {

    private int latitude;
    private int longitude;

}