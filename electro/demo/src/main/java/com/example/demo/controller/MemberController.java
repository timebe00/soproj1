package com.example.demo.controller;

import com.example.demo.entity.Member;;
import com.example.demo.service.MemberService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {
    @Autowired
    private MemberService service;

    @PostMapping("/sinup")
    public ResponseEntity<Member> sinup(@Validated @RequestBody Member member) throws Exception {
        log.info("Controller Member Sin up");
        service.sinup(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/mainmember")
    public ResponseEntity<List<Member>> mainmember() throws Exception {
        log.info("Controller Main Member");
        return new ResponseEntity<>(service.mainmember(), HttpStatus.OK);
    }

    @PostMapping("/mymember")
    public ResponseEntity<List<Member>> mymember(@Validated @RequestBody Member member) throws Exception {
        log.info("Controller My Member");
        log.info("Member : " + member.getId());
        return new ResponseEntity<>(service.mymember(member), HttpStatus.OK);
    }

    @PostMapping("/readmember")
    public ResponseEntity<Member> read (@Validated @RequestBody Member member) throws Exception {
        log.info("Member Read" + member.getMemberNo());
        Member member1 = service.read(member);
        return new ResponseEntity<Member>(member1, HttpStatus.OK);
    }
}
