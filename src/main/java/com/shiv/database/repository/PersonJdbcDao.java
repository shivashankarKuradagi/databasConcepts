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

}
