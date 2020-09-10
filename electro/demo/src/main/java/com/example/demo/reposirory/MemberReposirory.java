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
        String query = "insert into member(title, file, ex, id) values(?, ?, ?, ?)";
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
        log.info("memberId : " + member.getId());
        List<Member> res = jdbcTemplate.query(
                "select memberno, title, id date from member where id = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member1 = new Member();
                        member1.setMemberNo(rs.getInt("memberno"));
                        member1.setTitle(rs.getString("title"));

                        return member1;
                    }
                }, member.getId()
        );
        return res;
    }

    public Member read(Member member) throws Exception {
        log.info("Repository Read");
        List<Member> res = jdbcTemplate.query(
                "select title, file, ex from member where memberno = ?",
                new RowMapper<Member>() {
                @Override
                public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Member member = new Member();

                    member.setTitle(rs.getString("title"));
                    member.setFile(rs.getString("file"));
                    member.setEx(rs.getString("ex"));

                    return member;
                }
            }, member.getMemberNo()
        );
        return res.isEmpty() ? null : res.get(0);
    }

    public void delecte (Member member) throws Exception {
        String query = "delete from member where memberno = ?";
        jdbcTemplate.update(query,member.getMemberNo());
    }
}
