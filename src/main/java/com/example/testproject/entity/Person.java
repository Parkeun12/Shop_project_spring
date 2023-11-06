package com.example.testproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "test_table")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // db가 id 자동 생성
    private Long i_d;

    @Column(unique = true, length=10) //유일하고 최대 길이가 10.
    private String personName;
    @Column(name="person_age")
    private int age;
}
