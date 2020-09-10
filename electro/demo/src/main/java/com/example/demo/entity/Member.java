package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.BitSet;
import java.util.Date;

@JsonIgnoreProperties(value="hibernateLazyInitializer")
@Getter
@Setter
@EqualsAndHashCode(of = "memberNo")
@ToString
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberno")
    private int memberNo;

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "file", nullable = true)
    private String file;

    @Column(name = "ex", columnDefinition ="TEXT", nullable = true)
    private String ex;

    @Column(name = "id", nullable = true)
    private String id;
}
