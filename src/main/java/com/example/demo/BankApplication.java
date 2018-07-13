package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import antlr.collections.List;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.example.demo")

public class BankApplication {

	private static final Logger log = LoggerFactory.getLogger(BankApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(AccountRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Account(2D));
			repository.save(new Account(3D));
			Account a1 = new Account();
			a1.setCredit(4D);
			repository.save(a1);
			Account a2 = new Account();
			a2.setCredit(5D);
			repository.save(a2);
			
			//creating person and saving to db
			Person p = new Person();
			p.setFname("harika");
			p.setLname("rajavaram");
			Collection<Integer> l = new ArrayList<Integer>();
			l.add(100);
			l.add(200);
			p.listOfAccounts = (java.util.List<Integer>) l;
			
			// fetch all accounts
			log.info("Accounts found with findAll():");
			log.info("-------------------------------");
			for (Account a : repository.findAll()) {
				log.info(a.toString());
			}
			log.info("");
			// fetch accounts by ID, findById() - default function
			repository.findById(2L)
			.ifPresent(a -> {
				log.info("Account found with findById(1L):");
				log.info("--------------------------------");
				log.info(a.toString());
				log.info("");
			});
			// fetch accounts by credit value
			repository.findByCredit(4D)
			.ifPresent(a -> {
				log.info("Account found with findByCredit(1D):");
				log.info("--------------------------------");
				log.info(a.toString());
				log.info("");
			});
			

		};
	}
}
