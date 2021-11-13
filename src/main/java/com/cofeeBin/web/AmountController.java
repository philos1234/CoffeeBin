package com.cofeeBin.web;

import com.cofeeBin.repository.dao.BinDao;
import com.cofeeBin.service.AmountService;
import com.cofeeBin.service.JwtServiceImpl;
import com.cofeeBin.web.dto.AppRequestDto;
import com.cofeeBin.web.dto.amount.AmountGetResponseDto;
import com.cofeeBin.web.dto.amount.AmountSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class AmountController {

    private AmountService amountService;
    private JwtServiceImpl jwtServiceImple;
    @Autowired
    public AmountController(AmountService amountService, JwtServiceImpl jwtServiceImple){
        this.amountService = amountService;
        this.jwtServiceImple = jwtServiceImple;
    }

    //쓰레기통으로부터
    @PostMapping("/bin/amount")
    public String saveAmount(@RequestBody AmountSaveRequestDto amountSaveRequestDto) throws Exception {


        try{
            amountService.amountUpdate(amountSaveRequestDto);
            return "ok";
        }
        catch (Exception e){
            throw e;
        }

    }

    @PostMapping("/amount")
    public List<AmountGetResponseDto> getAmount(@RequestBody AppRequestDto appRequestDto) throws Exception {

        try{

            String token = appRequestDto.getToken();
        if(jwtServiceImple.checkJwt(token)){

            List<AmountGetResponseDto> ret = amountService.getAmount();
            return ret;
        }

        else {
            List<AmountGetResponseDto> ret = new ArrayList<>();
            return ret;
        }
        }catch (Exception e){
            throw e;

        }

    }



}
