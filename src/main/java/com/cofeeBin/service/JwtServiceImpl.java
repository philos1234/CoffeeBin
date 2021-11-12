package com.cofeeBin.service;


import com.cofeeBin.web.dto.login.KakaoLoginDto;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService{

    private String key;
    private final String ISSUER = "Hyun";

    public JwtServiceImpl(@Value("${token.key}") String key){
        this.key = key;
    }

    @Override
    public String makeJwt(KakaoLoginDto kakaoLoginDto) throws Exception {
        Map<String,Object> claims = new HashMap<>();
        claims.put("email",kakaoLoginDto.getEmail());
        claims.put("phoneNum",kakaoLoginDto.getPhoneNum());
        return Jwts.builder().setClaims(claims).setIssuer(ISSUER).signWith(SignatureAlgorithm.HS512,key).compact();

    }

    @Override
    public boolean checkJwt(String token) throws Exception {
        String ISS =Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer();
        if( ISS.equals(ISSUER))return true;
        else throw new RuntimeException("token invalid");

    }

    @Override
    public String getUserEmail(String token){
        String ret  = (String)Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().get("email");
        return ret;

    }

}
