package com.example.demo.Presentation;

import com.example.demo.Business.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {
    @Autowired
    CountryService service;

    @GetMapping("/start")
    public String start(){
        return "Welcome";
    }
    @PostMapping("/start")
    public String start1(@RequestParam String username){
        service.logIn(username);
        return "redirect:/";
    }


    @GetMapping("/")
    public String country(Model model) {
/*
        model.addAttribute("goalCountry", service.getGoalCountry());
*/
        service.init();
        char[] l= service.countryRepresentation();
        model.addAttribute("expectedCountry",l );
        return "country";
    }

    @PostMapping("/")
    public String countryPost(Model model, @RequestParam String inputChar) {
        char[] arrayOfguessedChar = service.currentClue(inputChar);
        if (service.isWon()) {
            service.won();
            return "gamewon";
        } else if (service.isLost()) {
            service.lost();
            model.addAttribute("goalCountry", service.getGoalCountry());
            return "gameover";
        } else {
            int getNumberofAttempts= service.getNoOfWrongattempts();
            int attemptsLeft= service.MAXATTEMPTS-getNumberofAttempts;
            model.addAttribute("wrongattempt", getNumberofAttempts);
            model.addAttribute("attemptsleft",attemptsLeft );
            model.addAttribute("guessedCountry", arrayOfguessedChar);
        }
        return "country";
    }

}