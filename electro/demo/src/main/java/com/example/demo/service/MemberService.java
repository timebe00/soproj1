package com.example.demo.service;

import com.example.demo.entity.Member;

import java.util.List;

public interface MemberService {
    public void sinup(Member member) throws Exception;
    public List<Member> mainmember() throws Exception;
    public List<Member> mymember(Member member) throws Exception;
}
