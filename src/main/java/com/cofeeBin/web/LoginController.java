package com.cofeeBin.web;

import com.cofeeBin.service.JwtService;
import com.cofeeBin.service.JwtServiceImpl;
import com.cofeeBin.web.dto.KakaoLoginDto;

import com.cofeeBin.web.dto.LoginResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private JwtServiceImpl jwtServiceImple;

    @Autowired
    public LoginController(JwtServiceImpl jwtService){
        this.jwtServiceImple  = jwtService;
    }

    @PostMapping("/kakaoLogin")
    public LoginResponseDto kakaoLogin(@RequestBody KakaoLoginDto kakaoLoginDto) throws Exception {
        String token = jwtServiceImple.makeJwt(kakaoLoginDto);
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        return loginResponseDto;
    }

}
