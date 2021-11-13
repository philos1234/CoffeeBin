package com.cofeeBin.web;


import com.cofeeBin.service.JwtServiceImpl;
import com.cofeeBin.service.MapService;
import com.cofeeBin.web.dto.AppRequestDto;
import com.cofeeBin.web.dto.map.MapGetResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MapController {

    private MapService mapService;
    private JwtServiceImpl jwtService;

    @Autowired
    public MapController(MapService mapService, JwtServiceImpl jwtService){
        this.jwtService = jwtService;
        this.mapService = mapService;

    }
    @PostMapping("/map")
    public List<MapGetResponseDto> getGPSINFO(@RequestBody AppRequestDto appRequestDto) throws Exception {

        try {
            String token = appRequestDto.getToken();
            jwtService.checkJwt(token);

            return mapService.getGPSInfo();
        }catch (Exception e){
            throw e;
        }
    }

}
