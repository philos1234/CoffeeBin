package com.cofeeBin.web;

import com.cofeeBin.service.JwtServiceImpl;
import com.cofeeBin.service.PointService;
import com.cofeeBin.service.UserService;
import com.cofeeBin.web.dto.User;
import com.cofeeBin.web.dto.AppRequestDto;
import com.cofeeBin.web.dto.point.PointGetResponseDto;

import com.cofeeBin.web.dto.point.PointSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class PointController {

    private JwtServiceImpl jwtServiceImple;
    private UserService userService;
    private PointService pointService;

    @Autowired
    public PointController(JwtServiceImpl jwtService, UserService userService, PointService pointService){

        this.jwtServiceImple  = jwtService;
        this.userService = userService;
        this.pointService = pointService;

    }

    @PostMapping("/point")
    public  List<PointGetResponseDto> getPoint(@RequestBody AppRequestDto appRequestDto) throws Exception {
        String token = appRequestDto.getToken();

        try {
            jwtServiceImple.checkJwt(token);
            String userEmail = jwtServiceImple.getUserEmail(token);
            User user = userService.getUserByEmail(userEmail);
            //유저 이메일로 ID를 찾아와서 다시 포인트 이력을 찾음
            List<PointGetResponseDto> pointHistoryDtoList = pointService.getHistory(user.getUserIdx());

            return pointHistoryDtoList;
        }catch (Exception e){
            throw e;
        }

    }


    @PostMapping("/bin/point")
    public String savePoint(@RequestBody PointSaveRequestDto pointSaveRequestDto) throws Exception {

       try {
           String phoneNum = pointSaveRequestDto.getPhone_number();
           User user = userService.getUserByPhoneNumber(phoneNum);
           int plus_point = 30;
           pointService.createHistory(user.getUserIdx(),plus_point,user.getPoint()+plus_point); //포인트 증가시키고 저장

           return "ok";
       }catch (Exception e){

           throw e;
       }


    }

}
