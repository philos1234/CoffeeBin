package com.cofeeBin.service;

import com.cofeeBin.web.dto.login.KakaoLoginDto;
import org.springframework.stereotype.Service;


@Service
public interface JwtService {
    public String makeJwt(KakaoLoginDto appRequestDto) throws Exception;
    public boolean checkJwt(String jwt) throws Exception;
    public String getUserEmail(String token);

}
