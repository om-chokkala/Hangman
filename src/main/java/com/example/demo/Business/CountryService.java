package com.example.demo.Business;

import com.example.demo.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CountryService {
    public CountryRepository repository;

    private char[] countryRepresentation;
    private String goalCountry;

    public String getGoalCountry() {
        return goalCountry;
    }

    public CountryService() {
        repository=new CountryRepository();
        goalCountry=randomCountry();
        countryRepresentation=randomCountryRepresentation();
    }

    public String randomCountry()
    {
        return repository.randomCountryGenerator().getCountryName();
    }

    public char[] randomCountryRepresentation()
    {
        char[] countryRepresentation = new char[goalCountry.length()];
        for(int i=0 ; i< countryRepresentation.length ;i++)
        {
           countryRepresentation[i]= '_';
        }
       return countryRepresentation;
    }
    public char[] currentClue(String charGuesses)
    {
        char firstChar= charGuesses.toUpperCase().charAt(0);

        for (int i = 0; i < goalCountry.length(); i++) {
            if (firstChar == goalCountry.charAt(i)) {
                countryRepresentation[i] = firstChar;
            }
        }
        return countryRepresentation;
    }


}
