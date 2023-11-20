package com.example.demoEbean;

import com.example.demoEbean.model.Country;
import com.example.demoEbean.service.CountryService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CountryServiceTest {
    @Autowired
    CountryService countryService;
    @Test
    public void FindAllCountry() {
        List<Country> list = countryService.findAll();
        Assertions.assertThat(list).isNotNull();
//        list.forEach(country -> System.out.println(country));
    }


    @Test
    public void FindAllCountryWithContinent() {
        List<Country> list = countryService.findAllWithContinent();
        Assertions.assertThat(list).isNotNull();

//        list.forEach(country -> System.out.println(country));
    }

    @Test
    public void FindById() {
       Country country = countryService.findById(1L);
        Assertions.assertThat(country).isNotNull();
//        System.out.println(Country);
    }


    @Test
    public void FindByIdWithError() {
        Country country = countryService.findById(1000L);
        Assertions.assertThat(country).isNull();
    }

    @Test
    public void FindByCode() {
        Country country = countryService.findByCode("IT");
        Assertions.assertThat(country).isNotNull();
        System.out.println(country);
    }


    @Test
    public void FindByCodeWithError() {
        Country country = countryService.findByCode("XX");
        Assertions.assertThat(country).isNull();
    }


    @Test
    public void FindByName() {
        Country country = countryService.findByName("ITALY");
        Assertions.assertThat(country).isNotNull();
//        System.out.println(Country);
    }


    @Test
    public void FindByNameWithError() {
        Country country = countryService.findByName("Italy123");
        Assertions.assertThat(country).isNull();
    }

}
