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
        reposirory.create(register);
    }

    @Override
    public Boolean overlap(String user_id) throws Exception {
        Boolean TF = false;
        TF = reposirory.overlap(user_id);
        return TF;
    }

    @Override
    public Register findID(Register register) throws Exception {
        return null;
    }

    @Override
    public Register uplodPw(Register register) throws Exception {
        return null;
    }
}
