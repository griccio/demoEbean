package com.example.demoEbean.service;

import com.example.demoEbean.model.Continent;
import com.example.demoEbean.model.ContinentDTO;
import com.example.demoEbean.repository.ContinentRepository;
import io.ebean.DB;
import io.ebean.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContinentService {

    @Autowired
    ContinentRepository continentRepository;

    public List<Continent> findAll(){
        return continentRepository.findAll();
    }

    public Continent findById(Long id) {
        return continentRepository.findById(id);
    }


    public Continent findByCode(String code) {
        return continentRepository.findByCode(code);
    }


    public Continent findByName(String name) {
        return continentRepository.findByName(name);
    }


    @Transactional
    public Continent save(Continent continent) {

        return continentRepository.save(continent);
    }

    @Transactional
    public Continent update(Continent continent) {
        return continentRepository.update(continent);
    }

    @Transactional
    public Boolean delete(Continent continent) {
        return continentRepository.delete(continent);
    }


}

