package com.chtti.demo.SpringBootJPADemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Beverage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String detail;

    public Beverage() {
    }

    public Beverage(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return String.format("[%s]/[%s]", title , detail);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
