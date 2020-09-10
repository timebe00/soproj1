package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.reposirory.MemberReposirory;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class MemberServicelmpl implements MemberService {

    @Autowired
    private MemberReposirory reposirory;

    @Override
    public void sinup(Member member) throws Exception {
        log.info("Service Sin Up");
        reposirory.create(member);
    }

    @Override
    public List<Member> mainmember() throws Exception {
        log.info("Service Main Member");
        return reposirory.mainmember();
    }

    @Override
    public List<Member> mymember(Member member) throws Exception {
        log.info("Service My Member");
        return reposirory.mymember(member);
    }

    @Override
    public Member read(Member member) throws Exception {
        return reposirory.read(member);
    }

    @Override
    public void delete(Member member) throws Exception {
        reposirory.delecte(member);
    }
}
