package com.cofeeBin.service;

import com.cofeeBin.repository.dao.UserDao;
import com.cofeeBin.web.dto.User;
import com.cofeeBin.web.dto.login.KakaoLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }



    public void createUserByKakao(KakaoLoginDto kakaoLoginDto,String token) throws Exception {
        try{

           int ret = userDao.createUserByKakao(kakaoLoginDto,token);
            if(ret == 0)throw new Exception();

        }catch (Exception e){
            throw e;
        }
    }

    public User getUserByEmail(String email) throws Exception {

        try {
            User ret = userDao.getUserByEmail(email);
            return ret;


        }catch (Exception exception){
            throw new Exception(exception.toString());

        }

    }

    public User getUserByPhoneNumber(String phoneNumber) throws Exception{
        try{

            User ret = userDao.getUserByPhoneNumber(phoneNumber);
            return ret;

        }catch (Exception exception){
            throw new Exception(exception.toString());
        }
    }

    public boolean checkUser(KakaoLoginDto kakaoLoginDto){
        try{
            if(userDao.checkUserByEmail(kakaoLoginDto.getEmail()) == 1){
                return true;
            }
            else return false;

        }catch (Exception e){
            throw e;
        }

    }

}
