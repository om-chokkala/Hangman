package com.example.demo;

import com.example.demo.Business.Country;
import com.example.demo.Repository.CountryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
class HangmanApplicationTests {
@Autowired
	private CountryRepository repository;
	@Test
	void contextLoads() {
	}
	@Test
	public void testFindCountry() {
		List<Country> countries = (List)repository.findAll();
		Assertions.assertTrue(countries.size() > 0);
	}

	@Test
	public void testFindCountry1() {
		Country country = repository.findById(1L).get();
		Assertions.assertEquals("SWEDEN", country.getCountryName());
	}

}
