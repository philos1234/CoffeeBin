package com.cofeeBin.web;

import com.cofeeBin.service.JwtServiceImpl;
import com.cofeeBin.service.UserService;
import com.cofeeBin.web.dto.login.KakaoLoginDto;

import com.cofeeBin.web.dto.login.LoginResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private JwtServiceImpl jwtServiceImple;
    private UserService userService;
    @Autowired
    public LoginController(JwtServiceImpl jwtService,UserService userService){
        this.jwtServiceImple  = jwtService;
        this.userService = userService;
    }

    @PostMapping("/kakaoLogin")
    public LoginResponseDto KakaoLogin(@RequestBody KakaoLoginDto kakaoLoginDto) throws Exception {
       try{
        String token = jwtServiceImple.makeJwt(kakaoLoginDto);
        userService.createUserByKakao(kakaoLoginDto,token);
        LoginResponseDto loginResponseDto = new LoginResponseDto(token);

        return loginResponseDto;
       }
       catch (Exception e){
           throw e;
       }
    }



}
