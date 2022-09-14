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

    @GetMapping("/start")
    public String start(){
        return "Welcome";
    }

    @GetMapping("/")
    public String country(Model model, HttpSession session) {

        CountryService service = new CountryService();
        session.setAttribute("service", service);
/*
        model.addAttribute("goalCountry", service.getGoalCountry());
*/
        model.addAttribute("expectedCountry", service.CountryRepresentation());
        return "country";
    }

    @PostMapping("/")
    public String countryPost(Model model, @RequestParam String inputChar, HttpSession session) {
        CountryService service = (CountryService) session.getAttribute("service");
        if (service == null) {
            service = new CountryService();
        }
        char[] arrayOfguessedChar = service.currentClue(inputChar);
        if (service.isWon()) {
            return "gamewon";
        } else if (service.isLost()) {
            session.setAttribute("service", service);
            model.addAttribute("goalCountry", service.getGoalCountry());
            return "gameover";
        } else {
            int getNumberofAttempts= service.getNoOfWrongattempts();
            int attemptsLeft= service.getMaxAttempts()-getNumberofAttempts;
            session.setAttribute("service", service);
            model.addAttribute("wrongattempt", getNumberofAttempts);
            model.addAttribute("attemptsleft",attemptsLeft );
            model.addAttribute("guessedCountry", arrayOfguessedChar);
        }
        return "country";
    }

}