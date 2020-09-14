package com.example.demo.service;

import com.example.demo.entity.File;
import com.example.demo.reposirory.FileReposirory;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class FileServicelmpl implements FileService {

    @Autowired
    private FileReposirory reposirory;

    @Override
    public void fileuplode(String file) throws Exception {
        reposirory.create(file);
    }
}
