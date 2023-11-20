package com.example.demoEbean;

import com.example.demoEbean.model.Continent;
import com.example.demoEbean.repository.ContinentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.PersistenceException;
import java.util.List;

@SpringBootTest
public class ContinentRepositoryTest {
    @Autowired
    ContinentRepository continentRepository;
    @Test
    public void FindAllContinent() {
        List<Continent> list = continentRepository.findAll();
        Assertions.assertThat(list).isNotNull();
//        list.forEach(country -> System.out.println(country));
    }
    @Test
    public void FindById() {
       Continent continent = continentRepository.findById(1L);
        Assertions.assertThat(continent).isNotNull();
//        System.out.println(continent);
    }


    @Test
    public void FindByIdWithError() {
        Continent continent = continentRepository.findById(1000L);
        Assertions.assertThat(continent).isNull();
    }

    @Test
    public void FindByCode() {
        Continent continent = continentRepository.findByCode("EU");
        Assertions.assertThat(continent).isNotNull();
        System.out.println(continent);
    }


    @Test
    public void FindByCodeWithError() {
        Continent continent = continentRepository.findByCode("XX");
        Assertions.assertThat(continent).isNull();
    }


    @Test
    public void FindByName() {
        Continent continent = continentRepository.findByName("EUROPE");
        Assertions.assertThat(continent).isNotNull();
//        System.out.println(continent);
    }


    @Test
    public void FindByNameWithError() {
        Continent continent = continentRepository.findByName("ITALY");
        Assertions.assertThat(continent).isNull();
    }

    @Test
    public void saveContinent(){
        int continentsAtTheStart = continentRepository.findAll().size();
        Continent continent = new Continent("XX" , "NEW CONTINENT XX");
        continentRepository.save(continent);
        Assertions.assertThat(continent).isNotNull();
        int continentsTotAfterInsert = continentRepository.findAll().size();
        Assertions.assertThat(continentsAtTheStart + 1).isEqualTo(continentsTotAfterInsert);
        System.out.println(continent);

        continentRepository.delete(continent);
//        count  the total of continent after the delete
        int continentsTotAfterDelete = continentRepository.findAll().size();
        Assertions.assertThat(continentsAtTheStart).isEqualTo(continentsTotAfterDelete);

    }

    @Test
    public void saveContinentWithError(){
        try {
            int continentsAtTheStart = continentRepository.findAll().size();
            Continent continent = new Continent("XXXXXXXXX-XXXXXXXX-XXXXX", "NEW CONTINENT XX");
            continentRepository.save(continent);
        }catch(PersistenceException pe){
            System.out.println(pe);
        }
    }



    @Test
    public void updateContinent(){
        int continentsAtTheStart = continentRepository.findAll().size();
        Continent continent = new Continent("XX" , "NEW CONTINENT XX");
        continentRepository.save(continent);
        Assertions.assertThat(continent).isNotNull();
        int continentsTotAfterInsert = continentRepository.findAll().size();
        Assertions.assertThat(continentsAtTheStart + 1).isEqualTo(continentsTotAfterInsert);
        System.out.println(continent);

        Continent continentTest = continentRepository.findById(continent.getId());
        continentTest.setCode("YY");
        continentTest.setName("UPDATED CONTINENT's NAME XX");

        continentRepository.update(continentTest);

        Continent newContinent = continentRepository.findByCode("YY");
        Assertions.assertThat(newContinent).isNotNull();
        Assertions.assertThat(newContinent.getCode()).isEqualTo("YY");
        Assertions.assertThat(newContinent.getName()).isEqualTo("UPDATED CONTINENT's NAME XX");

        //delete the Continent
        continentRepository.delete(newContinent);
        //count  the total of continent  after the delete
        int continentsTotAfterDelete = continentRepository.findAll().size();
        Assertions.assertThat(continentsAtTheStart).isEqualTo(continentsTotAfterDelete);





    }
}
