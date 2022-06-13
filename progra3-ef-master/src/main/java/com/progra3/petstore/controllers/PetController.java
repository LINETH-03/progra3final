package com.progra3.petstore.controllers;

import java.util.List;

import com.progra3.petstore.entities.Pet;
import com.progra3.petstore.services.PetService;

public class PetController {
	
	PetService service;
	
	public List<Pet> findAll(){
		return service.listAll();
	}
	
	public Pet findPet(Long id) {
		return service.findById(id);
	}
	
	public Pet createPet(Pet pet) {
		
	}
	
	public Pet updatePet(Long id, Pet pet) {
		
	}
	
	public void deletePet(Long id) {
		return service.deletePet(id);
	}

}
