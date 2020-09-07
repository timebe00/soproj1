package com.example.demo.service;

import com.example.demo.entity.Register;

public interface RegisterService {
    public void register(Register register) throws Exception;
    public Boolean overlap(Register register) throws Exception;
    public Register findID(Register register) throws Exception;
    public Register findPw(Register register) throws Exception;
    public void uplodPw(Register register) throws Exception;
    public Register login(Register register) throws Exception;
}
