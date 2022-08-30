package com.example.demo.Presentation;

import com.example.demo.Business.CountryService;
import com.example.demo.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CountryController {

    @Autowired
    CountryService service;


   @GetMapping("/")
    public String country(Model model){
       model.addAttribute("countryName",service.randomCountry());
       return "country";
   }

   @PostMapping("/")
    public String countryPost(Model model, @RequestParam char inputChar, HttpSession session){
       session.setAttribute("input",inputChar);
       model.addAttribute("compareChar",service.currentClue(inputChar));

       return "country";
   }
}
