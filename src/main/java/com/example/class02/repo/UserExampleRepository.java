package com.example.class02.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.class02.model.UserExample;

@Repository
public interface  UserExampleRepository extends CrudRepository<UserExample, Long>{
	
	public abstract ArrayList<UserExample> findByEdad(Integer edad);

}
