package com.example.demo.Business;

import com.example.demo.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CountryService {
    @Autowired
    public CountryRepository repository;
    private char[] countryRepresentation;
    private String goalCountry;
    private int noOfWrongattempts;

    private int maxAttempts = 10;

    private List<String> letters = new ArrayList<>();

    public CountryService() {
       // repository = new CountryRepository();
        goalCountry = "";//randomCountry();
        countryRepresentation = CountryRepresentation();
    }


    public List<String> getLetters() {
        return letters;
    }

    public CountryRepository getRepository() {
        return repository;
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

 /*   public String randomCountry()
    {
        return repository.randomCountryGenerator().getCountryName();
    }*/


    public char[] CountryRepresentation()
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
        Country country = new Country();
        Random rand= new Random();
        Long randomNumber= rand.nextLong(0,repository.count());
        country=repository.findAllById(randomNumber);
        return country;
    }

}
