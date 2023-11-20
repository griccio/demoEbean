package com.example.demoEbean;

import com.example.demoEbean.model.Country;
import com.example.demoEbean.repository.CountryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.PersistenceException;
import java.util.List;

@SpringBootTest
public class CountryRepositoryTest {
    @Autowired
    CountryRepository countryRepository;
    @Test
    public void FindAllCountry() {
        List<Country> list = countryRepository.findAll();
        Assertions.assertThat(list).isNotNull();
        list.forEach(country -> System.out.println(country));
    }

    @Test
    public void FindAllCountryWithContinent() {
        List<Country> list = countryRepository.findAllWithContinent();
        Assertions.assertThat(list).isNotNull();
        list.forEach(country -> System.out.println(country));
    }

    @Test
    public void FindById() {
       Country Country = countryRepository.findById(1L);
        Assertions.assertThat(Country).isNotNull();
//        System.out.println(Country);
    }


    @Test
    public void FindByIdWithError() {
        Country Country = countryRepository.findById(1000L);
        Assertions.assertThat(Country).isNull();
    }

    @Test
    public void FindByCode() {
        Country Country = countryRepository.findByCode("IT");
        Assertions.assertThat(Country).isNotNull();
        System.out.println(Country);
    }


    @Test
    public void FindByCodeWithError() {
        Country Country = countryRepository.findByCode("XX");
        Assertions.assertThat(Country).isNull();
    }


    @Test
    public void FindByName() {
        Country Country = countryRepository.findByName("ITALY");
        Assertions.assertThat(Country).isNotNull();
        System.out.println(Country);
    }


    @Test
    public void FindByNameWithError() {
        Country Country = countryRepository.findByName("ITALY123");
        Assertions.assertThat(Country).isNull();
    }

    @Test
    public void FindByContinentName() {
        List<Country> list = countryRepository.findByContinentName("EUROPE");
        Assertions.assertThat(list).isNotNull();
        list.forEach(country -> System.out.println(country));
    }

    @Test
    public void FindByContinentCode() {
        List<Country> list = countryRepository.findByContinentCode("EU");
        Assertions.assertThat(list).isNotNull();
        list.forEach(country -> System.out.println(country));
    }

    @Test
    public void saveCountry(){
        int CountrysAtTheStart = countryRepository.findAll().size();
        Country Country = new Country("XX" , "NEW Country XX");
        countryRepository.save(Country);
        Assertions.assertThat(Country).isNotNull();
        int CountrysTotAfterInsert = countryRepository.findAll().size();
        Assertions.assertThat(CountrysAtTheStart + 1).isEqualTo(CountrysTotAfterInsert);
        System.out.println(Country);

        countryRepository.delete(Country);
//        count  the total of Country after the delete
        int CountrysTotAfterDelete = countryRepository.findAll().size();
        Assertions.assertThat(CountrysAtTheStart).isEqualTo(CountrysTotAfterDelete);

    }

    @Test
    public void saveCountryWithError(){
        try {
            int CountrysAtTheStart = countryRepository.findAll().size();
            Country Country = new Country("XXXXXXXXX-XXXXXXXX-XXXXX", "NEW Country XX");
            countryRepository.save(Country);
        }catch(PersistenceException pe){
            System.out.println(pe);
        }
    }



    @Test
    public void updateCountry(){
        int CountrysAtTheStart = countryRepository.findAll().size();
        Country Country = new Country("XX" , "NEW Country XX");
        countryRepository.save(Country);
        Assertions.assertThat(Country).isNotNull();
        int CountrysTotAfterInsert = countryRepository.findAll().size();
        Assertions.assertThat(CountrysAtTheStart + 1).isEqualTo(CountrysTotAfterInsert);
        System.out.println(Country);

        Country CountryTest = countryRepository.findById(Country.getId());
        CountryTest.setCode("YY");
        CountryTest.setName("UPDATED Country's NAME XX");

        countryRepository.update(CountryTest);

        Country newCountry = countryRepository.findByCode("YY");
        Assertions.assertThat(newCountry).isNotNull();
        Assertions.assertThat(newCountry.getCode()).isEqualTo("YY");
        Assertions.assertThat(newCountry.getName()).isEqualTo("UPDATED Country's NAME XX");

        //delete the Country
        countryRepository.delete(newCountry);
        //count  the total of Country  after the delete
        int CountrysTotAfterDelete = countryRepository.findAll().size();
        Assertions.assertThat(CountrysAtTheStart).isEqualTo(CountrysTotAfterDelete);





    }
}
