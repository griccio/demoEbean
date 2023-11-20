package com.example.demoEbean.repository;

import com.example.demoEbean.model.Continent;

import java.util.List;

public interface ContinentDAO {
    public List<Continent> findAll();

    public Continent findById(Long id);


    public Continent findByCode(String code);

    public Continent findByName(String code);


    /**
     * return all the continent where the name is like the param code
     *
     * @param code
     * @return
     */
    public List<Continent> getByCode(String code);


    public List<Continent> getByName(String name);

    public Continent save(Continent continent);

    public Continent update(Continent continent);

    public Boolean delete(Continent continent);

}
