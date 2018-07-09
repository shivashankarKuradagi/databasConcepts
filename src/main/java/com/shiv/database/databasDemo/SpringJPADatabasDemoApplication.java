package com.shiv.database.databasDemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.shiv.database.repository.UserJPADao;


@SpringBootApplication
@ComponentScan({"com.shiv.database.entity","com.shiv.database.repository"})
public class SpringJPADatabasDemoApplication implements CommandLineRunner {

	
	@Autowired
	private UserJPADao dao;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());


	public static void main(String[] args) {
		SpringApplication.run(SpringJPADatabasDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user1 = new User("shivashankar", "Bangalore", new Date());
		User user2 = new User("Harish", "Bangalore", new Date());
		User user3 = new User("Deepak", "Bangalore", new Date());
		User user4 = new User("Naveen", "Bangalore", new Date());
		
		dao.createUser(user1);
		dao.createUser(user2);
		dao.createUser(user3);
		dao.createUser(user4);
		
	//	logger.info("Find all  : {} ", dao.findAllUser());
		logger.info("Find by iD  : {} ", dao.findById(1));
		
		User user = dao.findById(1);
		
		user.setLocation("changes Location");
		dao.updateUser(user);
		
		logger.info("all users {} ." , dao.findAllUser());
		
		// @formatter:off
		 
		// @formatter:on
		/*
		logger.info("All users : {} ", dao.findAll());

		
		logger.info("Find by Location  : {} ", dao.findByLocation("Bangalore"));
		
		logger.info("Find Name of Person by Id  : {} ", dao.findNameById(10001));
		
		logger.info("Delete Row : {} ", dao.deletePersonById(10002 ));
		
		logger.info("Insert person : {} ", dao.insertPerson(new Person(10005, "Vedansh", "Bgm", new Date())));
		
		logger.info("All users : {} ", dao.findAll());
*/	}
}
