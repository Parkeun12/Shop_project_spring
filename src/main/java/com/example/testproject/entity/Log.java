package com.example.testproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Log {
    @Id
    @GeneratedValue
    private Long i_d;
    @Column
    private String Id;
    @Column
    private String Pw;
    //Article 생성자 추가
    public Log(Long i_d, String Id, String Pw) {
        this.i_d = i_d;
        this.Id = Id;
        this.Pw = Pw;
    }
    //toString() 메소드 추가
    @Override
    public String toString() {
        return "Log{" +
                "i_d=" + i_d +
                ", Id='" + Id + '\'' +
                ", Pw='" + Pw + '\'' +
                '}';
    }
}
