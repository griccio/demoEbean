package com.example.demoEbean.repository;

import com.example.demoEbean.model.Country;
import com.example.demoEbean.model.Country;
import com.example.demoEbean.model.query.QCountry;
import io.ebean.DB;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepository implements CountryDAO{

    public List<Country> findAll(){
       return new  QCountry().orderBy("name").findList();
    }

    public List<Country> findAllWithContinent(){
        return new  QCountry().orderBy("name").continent.fetch().findList();
    }

    public Country findById(Long id){
        return DB.find(Country.class, id);
    }

    public Country findByCode(String code){
        return new QCountry().code.equalTo(code).findOne();
    }

    public Country findByName(String code){
        return new QCountry().name.equalTo(code).findOne();
    }

    @Override
    public List<Country> findByContinentCode(String code) {
        return new QCountry().continent.code.equalTo(code).findList();
    }

    @Override
    public List<Country> findByContinentName(String name) {
        return new QCountry().continent.name.equalTo(name).findList();
    }


    /**
     * return all the Country where the name is like the param code
     * @param code
     * @return
     */
    public List<Country> getByCode(String code){
        return new QCountry().code.like(code).findList();
    }

    public List<Country> getByName(String name){
        return new QCountry().code.like(name).findList();
    }

    public Country save(Country Country) {
        DB.save(Country);
        return Country;
    }

    public Country update(Country Country) {
        DB.update(Country);
        return Country;
    }

    public Boolean delete(Country Country) {
        return DB.delete(Country);
    }


}
