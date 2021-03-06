package com.cofeeBin.web.dto.map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class MapGetResponseDto {

    private String name;
    private String latitude;
    private String longitude;

}
