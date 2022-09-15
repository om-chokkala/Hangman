package com.example.demo.Business;

import com.example.demo.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@SessionScope
public class CountryService {
    @Autowired
    CountryRepository repository;
    private char[] countryRepresentation;
    private String goalCountry;
    private int noOfWrongattempts;

    private int maxAttempts = 10;
    private int score;

    private List<String> letters = new ArrayList<>();

    public CountryService(){}
    @PostConstruct
    public void init() {
       // repository = new CountryRepository();
        goalCountry = randomCountryGenerator().getCountryName();
        countryRepresentation = countryRepresentation();
    }
    public List<String> getLetters() {
        return letters;
    }

    public char[] getCountryRepresentation() {
        return countryRepresentation;
    }

    public String getGoalCountry() {
        return goalCountry;
    }
    public int getNoOfWrongattempts() {
        return noOfWrongattempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public char[] countryRepresentation()
    {
        char[] countryRepresentation = new char[goalCountry.length()];
        for(int i=0 ; i< countryRepresentation.length ;i++)
        {
           countryRepresentation[i]= '_';
        }
       return countryRepresentation;
    }

    public char[] currentClue(String charGuesses) {
        boolean ishit = false;
        if(!letters.contains(charGuesses)) {
            letters.add(charGuesses);
            char firstChar = charGuesses.toUpperCase().charAt(0);
            for (int i = 0; i < goalCountry.length(); i++) {

                if (firstChar == goalCountry.charAt(i)) {
                    ishit = true;
                    countryRepresentation[i] = firstChar;
                }
            }
            if (!ishit) {
                noOfWrongattempts++;
                score= noOfWrongattempts*100;
            }
            return countryRepresentation;
        }
            else
            {
                return countryRepresentation;
            }
        }

        public boolean isWon() {
            for (char c : countryRepresentation) {
                if (c == '_') {
                    return false;
                }
            }
            return true;
        }

    public boolean isLost() {

        return noOfWrongattempts > 10;
    }
      public Country randomCountryGenerator()
    {
        Random rand= new Random();
        int randomNumber= rand.nextInt(0,(int)repository.count());
        List<Country> countryList=repository.findAll();
        return countryList.get(randomNumber);
    }

}
