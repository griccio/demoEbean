package com.example.demoEbean.repository;

import com.example.demoEbean.model.Country;

import java.util.List;

public interface CountryDAO {
    public List<Country> findAll();

    public Country findById(Long id);

    public Country findByCode(String code);

    public Country findByName(String code);

    public List<Country> findByContinentCode(String code);
    public List<Country> findByContinentName(String name);

    /**
     * return all the Country where the name is like the param code
     *
     * @param code
     * @return
     */
    public List<Country> getByCode(String code);

    public List<Country> getByName(String name);

    public Country save(Country Country);

    public Country update(Country Country);

    public Boolean delete(Country Country);

}
