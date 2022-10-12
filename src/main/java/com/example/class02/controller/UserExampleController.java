package com.example.class02.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.class02.model.UserExample;
import com.example.class02.repo.UserExampleRepository;
import com.example.class02.service.UserExampleService;

@RestController
@RequestMapping("/user_example")
public class UserExampleController {
	
	@Autowired
	UserExampleService userExampleService;

	@GetMapping()
	public ArrayList<UserExample>getUserExample(){
		return userExampleService.getUserExample();		
	}
	
	@PostMapping
	public UserExample saveUser(@RequestBody UserExample user) {
		return this.userExampleService.saveUserExample(user);
	}
	
	@GetMapping(path = "/{id}" )
	public Optional<UserExample> getUserById(@PathVariable("id") Long id){
		return this.userExampleService.findById(id);		
	}
	
	@GetMapping("/query")
	public ArrayList<UserExample> getUserByEdad(@RequestParam("edad") Integer edad){ //@RequestParam = /query?edad=66
		return this.userExampleService.findByEdad(edad);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		boolean ok = this.userExampleService.removeUser(id);
		return ok ? ("Se eliminó el usuario con id "+id) : ("No se pudo eliminar el usuario con id "+id);
		//return this.userExampleService.removeUser(id) ? ("Se eliminó el usuario con id "+id) : ("No se pudo eliminar el usuario con id "+id);
	}
	
	@PutMapping("/update")
	public UserExample actualizar(@RequestBody UserExample userExample) {
		return this.userExampleService.saveUserExample(userExample);
	}
	
}
