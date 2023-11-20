package com.example.demoEbean.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Country extends Geography{

    public Country() {
    }

    public Country(String code, String name) {
        super(code, name);
    }

    public Country(String code, String name, Continent continent) {
        super(code, name);
        this.continent = continent;
    }

    @ManyToOne
    @JoinColumn(name = "continent_id")



    private Continent continent;

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }


    @Override
    public String toString() {
        return super.toString() + "Country{" +
                "continent=" + continent +
                "} " ;
    }
}
