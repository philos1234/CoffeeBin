package com.cofeeBin.web;


import com.cofeeBin.web.dto.AppRequestDto;
import com.cofeeBin.web.dto.map.MapGetResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {


    @PostMapping("/map")
    public MapGetResponseDto getGPSINFO(@RequestBody AppRequestDto appRequestDto){


    }

}
