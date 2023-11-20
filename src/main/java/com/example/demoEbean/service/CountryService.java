package com.example.demoEbean.service;

import com.example.demoEbean.model.Country;
import com.example.demoEbean.repository.CountryRepository;
import io.ebean.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryRepository CountryRepository;

    public List<Country> findAll(){
        return CountryRepository.findAll();
    }

    public List<Country> findAllWithContinent(){
        return CountryRepository.findAllWithContinent();
    }

    public Country findById(Long id) {
        return CountryRepository.findById(id);
    }


    public Country findByCode(String code) {
        return CountryRepository.findByCode(code);
    }


    public Country findByName(String name) {
        return CountryRepository.findByName(name);
    }


    public List<Country> findByContinentName(String name) {
        return CountryRepository.findByContinentName(name);
    }

    public List<Country> findByContinentCode(String code) {
        return CountryRepository.findByContinentName(code);
    }



    @Transactional
    public Country save(Country Country) {

        return CountryRepository.save(Country);
    }

    @Transactional
    public Country update(Country Country) {
        return CountryRepository.update(Country);
    }

    @Transactional
    public Boolean delete(Country Country) {
        return CountryRepository.delete(Country);
    }


}

