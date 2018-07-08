package com.shiv.database.databasDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.shiv.database.repository.PersonJdbcDao;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shiv.database.*"})
public class DatabasDemoApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabasDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("All users : {} ", dao.findAll());
	}
}
