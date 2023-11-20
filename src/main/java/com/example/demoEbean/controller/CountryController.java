package com.example.demoEbean.controller;

import com.example.demoEbean.exception.ContinentException;
import com.example.demoEbean.exception.CountryException;
import com.example.demoEbean.model.Continent;
import com.example.demoEbean.model.Country;
import com.example.demoEbean.service.ContinentService;
import com.example.demoEbean.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class CountryController {

    @Autowired
    CountryService countryService;


    @GetMapping("/countries")
    public String showCountryList(Model theModel) {

        //create a countryList of DTO
        List<Country> countryList = countryService.findAllWithContinent();

        //add countryList to the model
        theModel.addAttribute("countryList", countryList);

        return "country/list";
    }


    @GetMapping("/country")
    public String showCountryForm(Model theModel) {

        //create a new country
        Country theCountry= new Country();

        //add country to the model
        theModel.addAttribute("country", theCountry);

        return "country/country";
    }





    @PostMapping("/country")
    public String saveCountry(@Valid @ModelAttribute("country") Country country, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "redirect:/country";
        else {
            try {

                if(country.getId() == null)
                 countryService.save(country);
                else
                    countryService.update(country);

                return "redirect:/countries";
            }catch(Exception e){
                return "redirect:/country";
            }
        }
    }

    @GetMapping("/country/update")
    public String showCountryFormForUpdate(@RequestParam("countryId") Long id, Model model) {
        Country country = countryService.findById(id);
        //add country to the model
        model.addAttribute("country", country);

        return "country/country";
    }


    @GetMapping("/country/delete")
    public String deleteCountry(@RequestParam("countryId") Long id){
        try{
            Country country = countryService.findById(id);
            countryService.delete(country);
        }catch(Exception e){
            System.out.println(e);
        }

        return "redirect:/countries";
    }



}
