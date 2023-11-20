package com.example.demoEbean.repository;

import com.example.demoEbean.model.Continent;
import com.example.demoEbean.model.query.QContinent;
import io.ebean.DB;
import io.ebean.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContinentRepository implements ContinentDAO{
    public List<Continent> findAll(){
       return new  QContinent().orderBy("name").findList();
    }

    public Continent findById(Long id){
        return DB.find(Continent.class, id);
    }

    public Continent findByCode(String code){
        return new QContinent().code.equalTo(code).findOne();
    }

    public Continent findByName(String code){
        return new QContinent().name.equalTo(code).findOne();
    }

    /**
     * return all the continent where the name is like the param code
     * @param code
     * @return
     */
    public List<Continent> getByCode(String code){
        return new QContinent().code.like(code).findList();
    }

    public List<Continent> getByName(String name){
        return new QContinent().code.like(name).findList();
    }



    public Continent save(Continent continent) {
        DB.save(continent);
        return continent;
    }


    public Continent update(Continent continent) {
        DB.update(continent);
        return continent;
    }

    public Boolean delete(Continent continent) {
        return DB.delete(continent);
    }


}
