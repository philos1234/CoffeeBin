package com.cofeeBin.repository.dao;

import com.cofeeBin.web.dto.amount.AmountGetResponseDto;
import com.cofeeBin.web.dto.map.MapGetResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BinDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BinDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<MapGetResponseDto> getGPSInfo() {
        String query = "select name,latitude, longitude from Bin";

        return this.jdbcTemplate.query(query,((rs, rowNum) ->
                new MapGetResponseDto(
                        rs.getString("name"),
                        rs.getInt("latitude"),
                        rs.getInt("longitude"))
        ));
    }

    public int savePlasticAmount(String name, int plastic){
        String query = "update Bin set plastic_amount = ? where name = ?";
        Object[] param = new Object[]{plastic,name};
        return this.jdbcTemplate.update(query,param);

    }
    public int savePaperAmount (String name,int paper){
        String query = "update Bin set paper_amount = ? where name = ?";
        Object[] param = new Object[]{paper,name};

        return this.jdbcTemplate.update(query,param);

    }


    public List<AmountGetResponseDto> getAmount() {
        String query = "select name, plastic_amount, paper_amount from Bin";

        return this.jdbcTemplate.query(query, (rs, rowNum) ->
                new AmountGetResponseDto(
                        rs.getString("name")
                ,rs.getInt("plastic_amount")
                ,rs.getInt("paper_amount")
                ));

    }
}
