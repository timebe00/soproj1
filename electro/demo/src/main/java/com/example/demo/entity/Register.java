package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Register {
    private int userNo;
    private String name;
    private String id;
    private String pw;
    private int br;
}
