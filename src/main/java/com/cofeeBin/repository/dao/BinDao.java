package com.cofeeBin.repository.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BinDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BinDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }




}
