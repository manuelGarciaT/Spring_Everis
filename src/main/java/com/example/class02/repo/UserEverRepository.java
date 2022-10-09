package com.example.class02.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.class02.model.UserEver;

@Repository
public interface  UserEverRepository extends CrudRepository<UserEver, Long>{
	
	public abstract ArrayList<UserEver> findByEdad(Integer edad);

}
