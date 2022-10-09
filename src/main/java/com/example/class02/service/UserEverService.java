package com.example.class02.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.class02.model.UserEver;
import com.example.class02.repo.UserEverRepository;

@Service
public class UserEverService {

		@Autowired
		UserEverRepository userEverRepository;
		
		public ArrayList<UserEver> getUserEver(){
			return(ArrayList<UserEver>) userEverRepository.findAll();
		}
		
		public UserEver saveUserEver(UserEver userEver){
			return userEverRepository.save(userEver);
		}
		
		public ArrayList<UserEver> findByEdad(Integer edad){
			return userEverRepository.findByEdad(edad);
		}
		
		public Optional<UserEver> findById(Long id){
			return userEverRepository.findById(id);
		}
		
		public boolean removeUser(Long id) {
			try {
				this.userEverRepository.deleteById(id);
				return true;
			}catch (Exception e) {
				return false;
			}			
		}
}
