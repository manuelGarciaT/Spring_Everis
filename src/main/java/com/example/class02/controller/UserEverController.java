package com.example.class02.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.class02.model.UserEver;
import com.example.class02.service.UserEverService;

@RestController
@RequestMapping("/user_ever")
public class UserEverController {
	
	@Autowired
	UserEverService userEverService;

	@GetMapping()
	public ArrayList<UserEver>getUserEver(){
		return userEverService.getUserEver();		
	}
	
	@PostMapping
	public UserEver saveUser(@RequestBody UserEver user) {
		return this.userEverService.saveUserEver(user);
	}
	
	@GetMapping(path = "/{id}" )
	public Optional<UserEver> getUserById(@PathVariable("id") Long id){
		return this.userEverService.findById(id);		
	}
	
	@GetMapping("/query")
	public ArrayList<UserEver> getUserByEdad(@RequestParam("edad") Integer edad){ //@RequestParam = /query?edad=66
		return this.userEverService.findByEdad(edad);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		boolean ok = this.userEverService.removeUser(id);
		return ok ? ("Se eliminó el usuario con id "+id) : ("No se pudo eliminar el usuario con id "+id);
		//return this.userEverService.removeUser(id) ? ("Se eliminó el usuario con id "+id) : ("No se pudo eliminar el usuario con id "+id);
	}
	
}
