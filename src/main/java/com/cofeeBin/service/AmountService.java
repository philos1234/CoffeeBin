package com.cofeeBin.service;

import com.cofeeBin.repository.dao.BinDao;
import com.cofeeBin.web.dto.amount.AmountGetResponseDto;
import com.cofeeBin.web.dto.amount.AmountSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmountService {
    private BinDao binDao;

    @Autowired
    public AmountService(BinDao binDao){
        this.binDao = binDao;
    }

    public boolean amountUpdate(AmountSaveRequestDto amountSaveRequestDto) {
        try{
            String name = amountSaveRequestDto.getBin_name();
            int paper = amountSaveRequestDto.getPaper_amount();
            int plastic = amountSaveRequestDto.getPlastic_amount();
            int paperSaveRet = binDao.savePaperAmount(name,paper);
            int plasticSaveRet = binDao.savePlasticAmount(name,plastic);

            if(paperSaveRet == 1 && plasticSaveRet == 1)return true;
            else return false;

        }catch (Exception e){
            throw e;
        }

    }

    public List<AmountGetResponseDto> getAmount(){
        try{
            return binDao.getAmount();
        }catch (Exception e){
            throw e;
        }
    }
}
