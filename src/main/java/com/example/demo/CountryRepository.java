package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CountryRepository {

  private List<Country> countryList;


    public CountryRepository() {
       String a[]
                = new String[]{ "Sweden", "India", "Russia", "Canada","Brazil","Australi*/a","Argentina","Finland","Sudan","Norway" };

        this.countryList = new ArrayList<>();

        for(String i: a)
        {
            countryList.add(new Country(i));
        }
    }


  /*  @Override
    public String toString() {
        return "CountryRepository{" +
                "countryList=" + countryList.get(1).getCountryName() +
                '}';
    }*/
}
