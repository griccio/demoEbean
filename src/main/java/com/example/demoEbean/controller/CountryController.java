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

        //create a continentList of DTO
        List<Country> countryList = countryService.findAllWithContinent();

        //add continentList to the model
        theModel.addAttribute("countryList", countryList);

        return "country/list";
    }

//
//    @GetMapping("/continent")
//    public String showContinentForm(Model theModel) {
//
//        //create a new continent
//        Continent theContinent= new Continent();
//
//        //add continent to the model
//        theModel.addAttribute("continent", theContinent);
//
//        return "continent/continent";
//    }
//
//
//    @PostMapping("/country")
//    public String saveCountry(@Valid @ModelAttribute("country") Country country, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors())
//            return "redirect:/country";
//        else {
//            try {
//
//                if(country.getId() == null)
//                 countryService.save(country);
//                else
//                    countryService.update(country);
//
//                return "redirect:/countries";
//            }catch(Exception e){
//                return "redirect:/country";
//            }
//        }
//    }

    @PutMapping("/country")
    public String updateCountry() {
    return "HELLO";
    }






//    @GetMapping("/country")
//    public String showContinentFormForUpdate(@RequestParam("countryId") Long id, Model model) {
//        Country country = countryService.findById(id);
//        //add continent to the model
//        model.addAttribute("country", country);
//
//        return "country/country";
//    }
//
//    @PutMapping("/country")
//    public String updateContinent(@Valid @ModelAttribute("country") Country country, BindingResult bindingResult){
//        if(bindingResult.hasErrors())
//            return "country/country";
//        else {
//            countryService.update(country);
//            return "redirect:/showCountryList";
//        }
//    }
//
//    @GetMapping("/continent/delete")
//    public String deleteContinent(@RequestParam("countryId") Long id){
//    try{
//        Country country = countryService.findById(id);
//        countryService.delete(country);
//    }catch(Exception e){
//        System.out.println(e);
//    }
//
//        return "redirect:/continents";
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Country> findContinentById(@PathVariable Long id) {
//        try {
//            return ResponseEntity.ok(countryService.findById(id));
//        } catch (CountryException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }

}
