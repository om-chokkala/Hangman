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
    private int noOfWrongattempts=0;

    private final int maxAttempts= 10;

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

    public CountryService() {
        repository=new CountryRepository();
        goalCountry=randomCountry();
        countryRepresentation=CountryRepresentation();
    }

    public String randomCountry()
    {
        return repository.randomCountryGenerator().getCountryName();
    }

    public char[] CountryRepresentation()
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
        char firstChar = charGuesses.toUpperCase().charAt(0);
        for (int i = 0; i < goalCountry.length(); i++) {
            if (firstChar == goalCountry.charAt(i)) {
                countryRepresentation[i] = firstChar;
                //noOfWrongattempts--;
            }
            noOfWrongattempts++;
        }
        noOfWrongattempts= noOfWrongattempts-goalCountry.length()+1;
        System.out.println(noOfWrongattempts);
        return countryRepresentation;
    }

    public String endTheGame()
    {
        if(noOfWrongattempts == maxAttempts)
        {
            return "you lost the game";
        }
        return "You won";
    }


}
