package com.example.demo.Repository;

import com.example.demo.Business.Country;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class CountryRepository {

  private List<Country> countryList;


    public CountryRepository() {
       String a[]
                = new String[]{ "Sweden", "India", "Russia", "Canada","Brazil","Australia","Argentina","Finland","Sudan","Norway"};

        this.countryList = new ArrayList<>();

        for(String i: a)
        {
            countryList.add(new Country(i));
        }
    }

    public Country randomCountryGenerator()
    {
        Random rand= new Random();
        int randomNumber= rand.nextInt(0,countryList.size());
        return countryList.get(randomNumber);
    }


  /*  @Override
    public String toString() {
        return "CountryRepository{" +
                "countryList=" + countryList.get(1).getCountryName() +
                '}';
    }*/
}
