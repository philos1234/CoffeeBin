package com.cofeeBin.repository.dao;

import com.cofeeBin.web.dto.point.PointGetResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class HistoryDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HistoryDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<PointGetResponseDto> pointHistoryDtoList(int userIdx){
        int param = userIdx;
        return this.jdbcTemplate.query("select * from History where u_id = ?",
                (rs,rowNum) ->
            new PointGetResponseDto(
                    rs.getInt("plus_point"),
                    rs.getString("createAt"),
                    rs.getInt("cur_point")
            )
        ,param);
    }

    public int createHistory(int userIdx,int plusPoint, int curPoint)
    {
        Object[] param = new Object[]{userIdx,plusPoint,curPoint};
        return this.jdbcTemplate.update("insert into History(u_id,plus_point,cur_point) VALUES (?,?,?)",param);

    }




}

