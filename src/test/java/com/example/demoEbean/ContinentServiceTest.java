package com.example.demoEbean;

import com.example.demoEbean.model.Continent;
import com.example.demoEbean.repository.ContinentRepository;
import com.example.demoEbean.service.ContinentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ContinentServiceTest {
    @Autowired
    ContinentService continentService;
    @Test
    public void FindAllContinent() {
        List<Continent> list = continentService.findAll();
        Assertions.assertThat(list).isNotNull();
//        list.forEach(country -> System.out.println(country));
    }
    @Test
    public void FindById() {
       Continent continent = continentService.findById(1L);
        Assertions.assertThat(continent).isNotNull();
//        System.out.println(continent);
    }


    @Test
    public void FindByIdWithError() {
        Continent continent = continentService.findById(1000L);
        Assertions.assertThat(continent).isNull();
    }

    @Test
    public void FindByCode() {
        Continent continent = continentService.findByCode("EU");
        Assertions.assertThat(continent).isNotNull();
        System.out.println(continent);
    }


    @Test
    public void FindByCodeWithError() {
        Continent continent = continentService.findByCode("XX");
        Assertions.assertThat(continent).isNull();
    }


    @Test
    public void FindByName() {
        Continent continent = continentService.findByName("EUROPE");
        Assertions.assertThat(continent).isNotNull();
//        System.out.println(continent);
    }


    @Test
    public void FindByNameWithError() {
        Continent continent = continentService.findByName("ITALY");
        Assertions.assertThat(continent).isNull();
    }

}
