package com.cofeeBin.repository.dao;

import com.cofeeBin.web.dto.PointGetResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }



    public int userRes(String email){
        return this.jdbcTemplate.query("select * from History where email = ", (rs,rowNum) -> {
            PointGetResponseDto ret = new PointGetResponseDto();


        },email);

    }

}
