package com.example.demoEbean.model;

import io.ebean.annotation.NotNull;
import jakarta.validation.constraints.Size;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Geography {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    @NotNull
    @Size(max=2)
    private String code;

    @Column(nullable = false)
    @Size(max=100)
    private String name;

    public Geography() {
    }

    public Geography(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Geography{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}