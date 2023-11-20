package com.example.demoEbean.controller;

import com.example.demoEbean.exception.ContinentException;
import com.example.demoEbean.model.Continent;
import com.example.demoEbean.model.ContinentDTO;
import com.example.demoEbean.service.ContinentService;
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
public class ContinentController {

    @Autowired
    ContinentService continentService;

    @GetMapping("/hello")
    public String sayHello() {
        return "HELLO";
    }



    @GetMapping("/continents")
    public String showContinentList(Model theModel) {

        //create a continentList of DTO
        List<Continent> continentList = continentService.findAll();

        //add continentList to the model
        theModel.addAttribute("continentList", continentList);

        return "continent/list";
    }


    @GetMapping("/continent")
    public String showContinentForm(Model theModel) {

        //create a new continent
        Continent theContinent= new Continent();

        //add continent to the model
        theModel.addAttribute("continent", theContinent);

        return "continent/continent";
    }


    @PostMapping("/continent")
    public String saveContinent(@Valid @ModelAttribute("continent") Continent continent, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "redirect:/continent";
        else {
            try {

                if(continent.getId() == null)
                 continentService.save(continent);
                else
                    continentService.update(continent);

                return "redirect:/continents";
            }catch(Exception e){
                return "redirect:/continent";
            }
        }
    }



    @GetMapping("/continent/update")
    public String showContinentFormForUpdate(@RequestParam("continentId") Long id, Model model) {
        Continent continent = continentService.findById(id);
        //add continent to the model
        model.addAttribute("continent", continent);

        return "continent/continent";
    }

    @PostMapping("/continent/update")
    public String updateContinent(@Valid @ModelAttribute("continent") Continent continent, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "continent/continent";
        else {
            continentService.update(continent);
            return "redirect:/showContinentList";
        }
    }

    @GetMapping("/continent/delete")
    public String deleteContinent(@RequestParam("continentId") Long id){
    try{
        Continent continent = continentService.findById(id);
        continentService.delete(continent);
    }catch(Exception e){
        System.out.println(e);
    }

        return "redirect:/continents";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Continent> findContinentById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(continentService.findById(id));
        } catch (ContinentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
