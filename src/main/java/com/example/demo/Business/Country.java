package com.example.demo.Business;

public class Country {
    private String countryName;

    public Country()
    {

    }
    public Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
