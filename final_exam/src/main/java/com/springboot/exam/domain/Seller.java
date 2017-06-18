package com.springboot.exam.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Alan on 17/6/2017.
 */
@Document
public class Seller {
    @Id
    private String id;
    private String name;
    private long age;
    private long ci;
    private long numCarsSold;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getCi() {
        return ci;
    }

    public void setCi(long ci) {
        this.ci = ci;
    }

    public long getNumCarsSold() {
        return numCarsSold;
    }

    public void setNumCarsSold(long numCarsSold) {
        this.numCarsSold = numCarsSold;
    }
}
