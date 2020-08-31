package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Register {
    private int registerNo;
    private String userName;
    private String userId;
    private String userPassword;
    private int userBirthday;
}
