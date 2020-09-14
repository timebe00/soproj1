package com.example.demo.controller;

import com.example.demo.entity.Register;
import com.example.demo.service.RegisterService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RegisterController {
    @Autowired
    private RegisterService service;

    @PostMapping("/register")
    public ResponseEntity<Register> register(@Validated @RequestBody Register register) throws Exception {
        log.info("Controller Register");
        log.info("getUserName : " + register.getName() + "  getUserId : " + register.getId() + "  getUserPassword : " +
                register.getPw() + "  getUserBirthday : " + register.getBr());
        service.register(register);

        return new ResponseEntity<>(register, HttpStatus.OK);
    }

    @PostMapping("/overlap")
    public ResponseEntity<String> overlap(@Validated @RequestBody Register register) throws Exception {
        log.info("Controller Overlap");
        Boolean TF = false;
        TF = service.overlap(register);

        if (TF) {
            log.info("ok");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            log.info("No");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/findid")
    public ResponseEntity<Register> findid(@Validated @RequestBody Register register) throws Exception {
        log.info("Controller Find Id");
        Register getid;
        getid = service.findID(register);

        if (getid == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(getid, HttpStatus.OK);
        }
    }

    @PostMapping("/findpw")
    public ResponseEntity<Register> findpw(@Validated @RequestBody Register register) throws Exception {
        log.info("Controller Find Pw");
        Register getforid;
        getforid = service.findPw(register);

        if (getforid != null) {
            return new ResponseEntity<>(getforid,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("uplodpw")
    public void uplodepw(@Validated @RequestBody Register register) throws Exception {
        log.info("Controller Up Lod PW" );
        service.uplodPw(register);
    }

    @PostMapping("/login")
    public ResponseEntity<Register> login(@Validated @RequestBody Register register) throws Exception {
        log.info("Controller Login");
        Register getid;
        getid = service.login(register);

        if (getid != null) {
            return new ResponseEntity<>(getid, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
