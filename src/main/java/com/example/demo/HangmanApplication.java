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
			repo.save(new Country("ETHIOPIA"));
			repo.save(new Country("FINLAND"));
			repo.save(new Country("BELARUS"));
			repo.save(new Country("CANADA"));
			repo.save(new Country("BRAZIL"));
			repo.save(new Country("HAITI"));
			repo.save(new Country("LATVIA"));
			repo.save(new Country("MADAGASCAR"));
			repo.save(new Country("LIECHTENSTEIN"));
			repo.save(new Country("ICELAND"));
			repo.save(new Country("BHUTAN"));
			repo.save(new Country("LUXEMBOURG"));
		};
	}


}
