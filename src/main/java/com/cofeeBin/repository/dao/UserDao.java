package com.cofeeBin.repository.dao;

import com.cofeeBin.web.dto.User;
import com.cofeeBin.web.dto.point.PointGetResponseDto;
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


    public User getUserByEmail(String email) {
        return this.jdbcTemplate.queryForObject("select * from User where email = ?",
                (rs,rowNum) ->
            new User(
                    rs.getInt("ID"),
                    rs.getString("token"),
                    rs.getString("phone_num"),
                    rs.getString("email"),
                    rs.getInt("point"))
            , email);

    }

    public User getUserByPhoneNumber(String phoneNumber) {

        return this.jdbcTemplate.queryForObject("select * from User where phone_num = ?",
                (rs,rowNum)-> new User(       rs.getInt("ID"),
                        rs.getString("token"),
                        rs.getString("phone_num"),
                        rs.getString("email"),
                        rs.getInt("point") )
                ,phoneNumber);

    }
}
