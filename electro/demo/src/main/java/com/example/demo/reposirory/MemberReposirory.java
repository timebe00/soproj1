package com.example.demo.reposirory;

import com.example.demo.entity.Member;
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
public class MemberReposirory {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Member member) throws Exception {
        log.info("Repository Member Create");
        log.info("getUserName : " + member.getTitle() + " getFile : " + member.getFile() +
                " get ex : " + member.getEx() + "getId : " + member.getId() + "getDate : ");
        String query = "insert into register(title, file, ex, id, date) values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, member.getTitle(), member.getFile(), member.getEx(), member.getId());
    }

    public List<Member> mainmember() throws Exception {
        log.info("Repository Member Main Member");

        List<Member> res = jdbcTemplate.query(
                "select memberno, title, id from member",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member1 = new Member();
                        member1.setMemberNo(rs.getInt("memberno"));
                        member1.setTitle(rs.getString("title"));
                        member1.setId(rs.getString("id"));
                        return member1;
                    }
                }
        );
        return res;
    }

    public List<Member> mymember(Member member) throws Exception {
        log.info("Repository Member My Member");

        List<Member> res = jdbcTemplate.query(
                "select memberno, title, id date from member where id = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member1 = new Member();
                        member1.setMemberNo(rs.getInt("memberno"));
                        member1.setTitle(rs.getString("title"));
                        member1.setId(rs.getString("id"));

                        return member1;
                    }
                }, member.getId()
        );
        return res;
    }

}
