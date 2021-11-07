package com.cofeeBin.repository.dao;

import com.cofeeBin.web.dto.PointGetResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class HistoryDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HistoryDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<PointGetResponseDto> pointRes(String email){
        return this.jdbcTemplate.query("select * from History where email = ", (rs,rowNum) -> {
            PointGetResponseDto ret = new PointGetResponseDto();


        },email);
    }


}

