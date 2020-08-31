package com.example.demo.reposirory;

import com.example.demo.entity.Register;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Log
@Repository
public class RegisterReposirory {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Register register) throws Exception {
        log.info("Repository Create");

        String query = "insert into board(" +
                "user_name, user_id, user_password, user_birthday) values(?, ?, ?, ?)";
        jdbcTemplate.update(query, register.getUserName(), register.getUserId(),
            register.getUserPassword(), register.getUserBirthday());
    }

    public Boolean overlap(String user_id) throws Exception {
        log.info("Repository Overlap");

        List<Register> res = jdbcTemplate.query(
                "select user_id from register where user_id = ?",
                new RowMapper<Register>() {
                    @Override
                    public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Register register = new Register();

                        register.setUserId(rs.getString("user_id"));

                        return register;
                    }
                }, user_id
        );

        return res.isEmpty() ? false : true;
    }
}
