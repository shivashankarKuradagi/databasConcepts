package com.shiv.database.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shiv.database.databasDemo.User;

@Component
@Repository
@Transactional
public class UserJPADao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public User createUser(User user)
	{
		return entityManager.merge(user);
	}
	
	public User findById(int id)
	{
		return entityManager.find(User.class, id);
	}
		
	public User updateUser(User user)
	{
		return entityManager.merge(user);
	}
	
	public List<User> findAllUser()
	{
		TypedQuery<User> users = entityManager.createNamedQuery("SELECT_ALL_USER", User.class);
		return users.getResultList();
	}

	public void deleteUser(int id) {
		User user = findById(id);
		entityManager.remove(user);
	}
	
	
	
}
