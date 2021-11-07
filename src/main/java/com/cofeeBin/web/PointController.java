package com.cofeeBin.web;

import com.cofeeBin.service.JwtServiceImpl;
import com.cofeeBin.web.dto.AmountSaveRequestDto;
import com.cofeeBin.web.dto.AppRequestDto;
import com.cofeeBin.web.dto.PointGetResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PointController {

    private JwtServiceImpl jwtServiceImple;


    @Autowired
    public PointController(JwtServiceImpl jwtService){
        this.jwtServiceImple  = jwtService;
    }

    @PostMapping("/point")
    public PointGetResponseDto getPoint(@RequestBody AppRequestDto appRequestDto) throws Exception {
        String token = appRequestDto.getToken();

        try {
            jwtServiceImple.checkJwt(token);
            String userEmail = jwtServiceImple.getUserEmail(token);
            PointGetResponseDto pointGetResponseDto = new PointGetResponseDto();
            return pointGetResponseDto;
        }catch (Exception e){
            throw e;
        }

    }


//    @PostMapping("/bin/point")
//    public String savePoint(@RequestBody AmountSaveRequestDto amountSaveRequestDto){
//
//
//    }

}
