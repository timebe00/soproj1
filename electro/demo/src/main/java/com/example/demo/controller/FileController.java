package com.example.demo.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Iterator;
import java.util.function.Supplier;

@Log
@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FileController {

    @PostMapping("/file")
    public ResponseEntity<String> sinup(HttpServletRequest request) throws Exception {
        log.info("Controller File Sin Up");

        MultipartHttpServletRequest mult = null;
        String original = "";
        if(request instanceof MultipartHttpServletRequest)       //  request가 MultipartHttpServletRequest 로형변환 가능한가
        {
            log.info("yes");
            mult = (MultipartHttpServletRequest)request;

            Iterator<String> iterator = mult.getFileNames();
            MultipartFile fil = mult.getFile(iterator.next());

            original = fil.getOriginalFilename();

            String fileTeg = original;
            String filePath = "D:\\Git\\Bitcamp\\Project\\soproj1\\pythonwork";
            File file = new File(filePath + "\\" + fileTeg);
            fil.transferTo(file);
        }

        return new ResponseEntity<>(original,HttpStatus.OK);
    }

    @PostMapping("/remove")
    public ResponseEntity<String> remove(HttpServletRequest request) throws Exception
    {
        log.info("Controller File Remove");

        if(request instanceof MultipartHttpServletRequest)       //  request가 MultipartHttpServletRequest 로형변환 가능한가
        {
            log.info("yes");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/pythonwork")
    public ResponseEntity<String> pythonwork(@RequestBody String nick) throws Exception
    {
        log.info("Controller Python Work : " + nick);
        char name[] = new char[nick.length()];
        for(int i=0; i<nick.length(); i++)
        {
            name[i] = nick.charAt(i);
        }
        for(int i=0; i<nick.length(); i++)
        {
            log.info(String.valueOf(name[i]));
        }


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
