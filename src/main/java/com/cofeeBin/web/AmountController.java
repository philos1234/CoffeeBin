package com.cofeeBin.web;

import com.cofeeBin.web.dto.AmountSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AmountController {

    @PostMapping("/api/amount")
    public AmountSaveRequestDto saveAmount(@RequestBody AmountSaveRequestDto amountSaveRequestDto) {

        return amountSaveRequestDto;
    }


}
