package com.dh.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Alan on 10/6/2017.
 */
@Document
public class Student {
    @Id
    private String id;
    private String name;
    private long ci;
    private long codeSis;

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

    public long getCi() {
        return ci;
    }

    public void setCi(long ci) {
        this.ci = ci;
    }

    public long getCodeSis() {
        return codeSis;
    }

    public void setCodeSis(long codeSis) {
        this.codeSis = codeSis;
    }
}
