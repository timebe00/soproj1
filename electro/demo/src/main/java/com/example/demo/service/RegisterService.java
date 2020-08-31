package com.example.demo.service;

import com.example.demo.entity.Register;

public interface RegisterService {
    public void register(Register register) throws Exception;
    public Boolean overlap(String user_id) throws Exception;
    public Register findID(Register register) throws Exception;
    public Register uplodPw(Register register) throws Exception;
}
