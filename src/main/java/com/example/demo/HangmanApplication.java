package com.example.demo;

import com.example.demo.Business.Country;
import com.example.demo.Business.CountryService;
import com.example.demo.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HangmanApplication {



	public static void main(String[] args) {
		SpringApplication.run(HangmanApplication.class, args);


	}
	@Bean
	public CommandLineRunner run(CountryRepository repo)  {
		return args -> {
			repo.save(new Country("SWEDEN"));
			repo.save(new Country("FINLAND"));
			repo.save(new Country("NORWAY"));
		};
	}


}
