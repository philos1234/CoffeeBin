package com.cofeeBin.service;

import com.cofeeBin.repository.dao.BinDao;
import com.cofeeBin.web.dto.map.MapGetResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {

    private BinDao binDao;

    @Autowired
    public MapService(BinDao mapDao){
        this.binDao = mapDao;
    }


    public List<MapGetResponseDto> getGPSInfo() throws Exception {
        try{
            return binDao.getGPSInfo();

        }catch (Exception e){
            throw e;
        }
    }


}
