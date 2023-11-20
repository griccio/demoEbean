package com.example.demoEbean.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {


    @GetMapping("/showForm")
    public String showForm(){
        return "hello/helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "hello/helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String processFormVersionTwo(HttpServletRequest request, Model model){

        //read the request
        String theName = request.getParameter("studentName");

        //convert the data
        theName = theName.toUpperCase();

        //create the message
        String result = "Yo! " + theName;

        //add message
        model.addAttribute("message", result);

        return "helloworld/helloworld";
    }

    @GetMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){

        //convert the data
        theName = theName.toUpperCase();

        //create the message
        String result = "Hey my friend from v3! " + theName;

        //add message
        model.addAttribute("message", result);

        return "helloworld/helloworld";
    }

}
