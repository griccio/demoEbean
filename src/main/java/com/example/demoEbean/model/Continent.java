package com.example.demoEbean.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "continent")
public class Continent extends Geography {

    public Continent() {
    }

    @OneToMany(mappedBy = "continent")
    List<Country> countryList = new ArrayList<>();

    public Continent(String code, String name) {
        super(code, name);
    }
}
