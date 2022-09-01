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

       CountryService service= new CountryService();
       session.setAttribute("service",service);
       model.addAttribute("goalCountry",service.getGoalCountry());
       model.addAttribute("expectedCountry",service.CountryRepresentation());
       return "country";
   }
  @PostMapping("/")
    public String countryPost(Model model, @RequestParam String inputChar, HttpSession session){
       CountryService service =(CountryService) session.getAttribute("service");
       if(service == null)
       {
           service= new CountryService();
       }
      if(service.getGoalCountry().equals(service.getCountryRepresentation()))
      {
          return "rediect:/endgame";
      }
       char[] arrayOfguessedChar =service.currentClue(inputChar);
       session.setAttribute("service",service);
       model.addAttribute("guessedCountry",arrayOfguessedChar);
       return "country";
   }

  /* @GetMapping("/endgame")
    public String getGameWon() {

       return "gameover";
    }*/
        @GetMapping("/endgame")
    public String getGameWon(Model model,HttpSession session){
        CountryService service = (CountryService) session.getAttribute("service");
         String result= service.endTheGame();
            session.setAttribute("service",service);
            model.addAttribute("endgame",result);
            session.invalidate();
        return "gameover";
    }

 /*   @PostMapping("/")
    public String countryPost(Model model, @RequestParam String inputChar){
       model.addAttribute("compareChar",service.currentClue(inputChar));
       return "country";
   }*/
}
