package com.cofeeBin.web;

import com.cofeeBin.web.dto.KakaoLoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @PostMapping("/kakaoLogin")
    public KakaoLoginDto kakaoLogin(@RequestBody KakaoLoginDto kakaoLoginDto){

        return kakaoLoginDto;
    }

}
