package com.shiv.database.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shiv.database.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 * @return
	 */
	public List<Person> findAll() {

		return jdbcTemplate.query("select * from person", 
				new BeanPropertyRowMapper(Person.class));
	}

	
	public Person findById(int id) {
		 return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {id}, new BeanPropertyRowMapper<>(Person.class));

		 
	}


	public List<Person> findByLocation(String location) {
		
		return jdbcTemplate.query("select * from person where location=?", new Object[] {location}, new BeanPropertyRowMapper<>(Person.class));
	}


	public Object findNameById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select name from person where id=?", new Object[] {id}, String.class);
	}


	public Object deletePersonById(int id) {
		return jdbcTemplate.update("delete from person where id = ?", new Object[] {id});
	}


	public Object insertPerson(Person person) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into person (id, name, location, birth_date) values (?, ?, ?, ?) ", new Object[] {
			person.getId(), person.getName(), person.getLocation(), person.getBirthDate()
		});
	}
	
}
