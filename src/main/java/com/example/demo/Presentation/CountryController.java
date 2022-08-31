package com.example.demo.Presentation;

import com.example.demo.Business.Country;
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


   @GetMapping("/")
    public String country(Model model,HttpSession session){
       System.out.println("omp");
       CountryService service= new CountryService();
       System.out.println("Group4");
       session.setAttribute("service",service);

      model.addAttribute("goalCountry",service.getGoalCountry());
       model.addAttribute("stringRep",service.randomCountryRepresentation());
       return "country";
   }
  @PostMapping("/")
    public String countryPost(Model model, @RequestParam String inputChar, HttpSession session){

       CountryService service =(CountryService) session.getAttribute("service");
       if(service == null)
       {
           service= new CountryService();
       }
       char[] modifiedWord =service.currentClue(inputChar);

       session.setAttribute("service",service);

       model.addAttribute("stringRep",modifiedWord);
       return "country";
   }

 /*   @PostMapping("/")
    public String countryPost(Model model, @RequestParam String inputChar){
       model.addAttribute("compareChar",service.currentClue(inputChar));
       return "country";
   }*/
}
