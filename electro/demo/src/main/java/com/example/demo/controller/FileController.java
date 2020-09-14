package com.example.demo.controller;

import com.example.demo.service.FileService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Iterator;

@Log
@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FileController {

    @Autowired
    private FileService service;

    @PostMapping("/file")
    public ResponseEntity<String> sinup(HttpServletRequest request) throws Exception {
        log.info("Controller File Sin Up");
        log.info("request : " + request);

        MultipartHttpServletRequest mult = null;

        if(request instanceof MultipartHttpServletRequest)       //  request가 MultipartHttpServletRequest 로형변환 가능한가
        {
            log.info("yes");
            mult = (MultipartHttpServletRequest)request;
            log.info("mult : " + mult);
        }
        Iterator<String> iterator = mult.getFileNames();
        MultipartFile fil = mult.getFile(iterator.next());

        String original = "";
        original = fil.getOriginalFilename();

        String fileTeg = original;
        String filePath = "D:\\Git\\Bitcamp\\Project\\soproj1\\pythonwork";
        File file = new File(filePath + "\\" + fileTeg);
        fil.transferTo(file);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
