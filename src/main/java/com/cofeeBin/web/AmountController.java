package com.cofeeBin.web;

import com.cofeeBin.web.dto.amount.AmountSaveRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AmountController {

    //쓰레기통으로부터
    @PostMapping("/bin/amount")
    public String saveAmount(@RequestBody AmountSaveRequestDto amountSaveRequestDto) {


        return "ok";
    }

//    @PostMapping("/amount")
//    public AmountGetResponseDto getAmount(@RequestBody AppRequestDto appRequestDto){
//
//
//
//    }



}
