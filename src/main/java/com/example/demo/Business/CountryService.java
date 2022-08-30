package com.example.demo.Business;

import com.example.demo.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    public CountryRepository repository;

    public String randomCountry()
    {
        //String randCountryName= repository.randomCountryGenerator().getCountryName();
        String country= "__  ";
       int templength= repository.randomCountryGenerator().getCountryName().length();
       return country.repeat(templength);

    }

    public List<Character> currentClue(char correctGuesses)
    {


        List<Character> clue = new ArrayList<>();

        for (int i = 0; i < randomCountry().length(); i++) {
            int indexPosition;
            char c = randomCountry().charAt(i);
            if (correctGuesses == c) {
                indexPosition = i;
                clue<indexPosition> = c;
            }
            else {
                clue.add(null);
            }
        }
        return clue;
    }










}
