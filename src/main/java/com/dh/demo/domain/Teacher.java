package com.dh.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Alan on 3/6/2017.
 */
@Document
public class Teacher {

    @Id
    private String id;

    private String name;
    private long ci;
    private String profession;

    // Tiene constructor por defecto que es vacio
    public Teacher() {

    }

    // Cuando se agregar un constructor se debe agregar tb el constructor vacio por defecto
    public Teacher(String id, String name, long ci, String profession) {
        this.id = id;
        this.name = name;
        this.ci = ci;
        this.profession = profession;
    }

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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
