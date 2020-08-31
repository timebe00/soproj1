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
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RegisterController {
    @Autowired
    private RegisterService service;

    @PostMapping("/")
    public ResponseEntity<Register> register(@Validated @RequestBody Register register) throws Exception {
        log.info("Controller Register");

        service.register(register);

        return new ResponseEntity<>(register, HttpStatus.OK);
    }

    @GetMapping("/overlap")
    public ResponseEntity<String> overlap(@Validated @RequestBody String user_id) throws Exception {
        log.info("Controller Overlap");
        Boolean TF = false;
        TF = service.overlap(user_id);

        if (TF) {
            return new ResponseEntity<>(user_id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(user_id, HttpStatus.OK);
        }
    }


}
