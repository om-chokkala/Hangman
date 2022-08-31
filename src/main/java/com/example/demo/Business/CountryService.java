package com.example.demo.Business;

import com.example.demo.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    public CountryRepository repository;

    public String randomCountry()
    {
        return repository.randomCountryGenerator().getCountryName();
    }

    public char[] randomCountryRepresentation()
    {
        char[] countryRepresentation = new char[randomCountry().length()];

        for(int i=0 ; i< countryRepresentation.length ;i++)

        {
           countryRepresentation[i]= '_';
        }
       return countryRepresentation;
    }

    public char[] currentClue(String charGuesses)
    {
        char firstChar= charGuesses.toUpperCase().charAt(0);
        String randomCountry= randomCountry();
        char[] tempRepresentation = randomCountryRepresentation();
        for (int i = 0; i < randomCountry.length(); i++) {
            if (firstChar == randomCountry.charAt(i)) {
                tempRepresentation[i] = firstChar;
            }
        }
        return tempRepresentation;
    }









}
