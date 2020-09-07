package com.example.demo.service;

import com.example.demo.entity.Register;
import com.example.demo.reposirory.RegisterReposirory;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class RegistrerServicelmpl implements RegisterService{

    @Autowired
    private RegisterReposirory reposirory;

    @Override
    public void register(Register register) throws Exception {
        log.info("Service Register");
        reposirory.create(register);
    }

    @Override
    public Boolean overlap(Register register) throws Exception {
        log.info("Service Overlap");
        Boolean TF = false;
        TF = reposirory.overlap(register);
        return TF;
    }

    @Override
    public Register findID(Register register) throws Exception {
        log.info("Service Find ID");
        Register getforid;
        getforid = reposirory.findid(register);
        return getforid;
    }

    @Override
    public Register findPw(Register register) throws Exception {
        log.info("Service Find Pw");
        Register getforid;
        getforid = reposirory.findpw(register);
        return getforid;
    }

    @Override
    public void uplodPw(Register register) throws Exception {
        log.info("Service Up Lod Pw");
        reposirory.uplodpw(register);
    }

    @Override
    public Register login(Register register) throws Exception {
        log.info("Service Login");
        Register getid;
        getid = reposirory.login(register);

        return getid;
    }
}
