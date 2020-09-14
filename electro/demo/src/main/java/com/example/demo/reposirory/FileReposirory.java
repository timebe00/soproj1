package com.example.demo.reposirory;

import com.example.demo.entity.File;
import com.example.demo.entity.Member;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Log
@Repository
public class FileReposirory {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(String file) throws Exception {
        log.info("Repository Member Create");
        String query = "insert into member(file) values(?)";
        jdbcTemplate.update(query, file);
    }
}
