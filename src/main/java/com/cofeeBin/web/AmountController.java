package com.cofeeBin.web;

import com.cofeeBin.web.dto.AmountSaveRequestDto;
import com.cofeeBin.web.dto.forTest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AmountController {

    @PostMapping("/api/amount")
    public AmountSaveRequestDto saveAmount(@RequestBody AmountSaveRequestDto amountSaveRequestDto) {

        return amountSaveRequestDto;
    }

    @PostMapping("/api/and/amount")
    public forTest android(@RequestBody forTest tt){
        return tt;
    }



}
