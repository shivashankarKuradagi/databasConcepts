package com.shiv.database.databasDemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.shiv.database.entity.Person;
import com.shiv.database.repository.PersonJdbcDao;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shiv.database.*"})
public class SpringJDBCDatabasDemoApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJDBCDatabasDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("All users : {} ", dao.findAll());
		
		logger.info("Find by iD  : {} ", dao.findById(10001));
		
		logger.info("Find by Location  : {} ", dao.findByLocation("Bangalore"));
		
		logger.info("Find Name of Person by Id  : {} ", dao.findNameById(10001));
		
		logger.info("Delete Row : {} ", dao.deletePersonById(10002 ));
		
		logger.info("Insert person : {} ", dao.insertPerson(new Person(10005, "Vedansh", "Bgm", new Date())));
		
		logger.info("All users : {} ", dao.findAll());
	}
}
