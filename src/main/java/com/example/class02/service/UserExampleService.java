package com.example.class02.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.class02.model.UserExample;
import com.example.class02.repo.UserExampleRepository;

@Service
public class UserExampleService {

		@Autowired
		UserExampleRepository userExampleRepository;
		
		public ArrayList<UserExample> getUserExample(){
			return(ArrayList<UserExample>) userExampleRepository.findAll();
		}
		
		public UserExample saveUserExample(UserExample userExample){
			return userExampleRepository.save(userExample);
		}
		
		public ArrayList<UserExample> findByEdad(Integer edad){
			return userExampleRepository.findByEdad(edad);
		}
		
		public Optional<UserExample> findById(Long id){
			return userExampleRepository.findById(id);
		}
		
		public boolean removeUser(Long id) {
			try {
				this.userExampleRepository.deleteById(id);
				return true;
			}catch (Exception e) {
				return false;
			}			
		}
}
