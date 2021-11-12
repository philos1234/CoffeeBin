package com.cofeeBin.service;

import com.cofeeBin.repository.dao.HistoryDao;
import com.cofeeBin.web.dto.point.PointGetResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {


    private HistoryDao historyDao;

    @Autowired
    public PointService(HistoryDao historyDao){
        this.historyDao = historyDao;
    }


    public List<PointGetResponseDto> getHistory(int userIdx) throws Exception{
        try{
            List<PointGetResponseDto> ret = historyDao.pointHistoryDtoList(userIdx);
            return ret;

        }catch (Exception exception){
            throw new Exception("포인트 히스토리 exception");
        }

    }

    public void createHistory(int userIdx,int plus_point,int cur_point) throws Exception{

        try {
            historyDao.createHistory(userIdx, plus_point, cur_point);
        }catch (Exception exception){
            throw new Exception("히스토리 생성 exception");
        }
    }
}
