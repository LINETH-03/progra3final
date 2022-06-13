package com.progra3.petstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progra3.petstore.Dao.PetDao;
import com.progra3.petstore.entities.Pet;
import com.progra3.petstore.exceptions.NotFoundException;
@Service
public class PetServiceimpl implements PetService {
	 @Autowired
	 PetDao petdao;

	@Override
	public List<Pet> listAll() {
		// TODO Auto-generated method stub
		return (List<Pet>) petdao.findAll();	
	}

	@Override
	public Pet findById(Long id) {
		Optional<Pet> opPet = petdao.findById(id);

        if(opPet.isPresent()) {
            return opPet.get();

        }else {

            throw new NotFoundException("No existe Mascota");
        }
	}

	@Override
	public void createPet(Pet pet) {
		petdao.save(pet);}

	@Override
	public void updatePet(Long id, Pet pet) {
		 if(petdao.existsById(id)) {
	            pet.setId(id);
	            petdao.save(pet);
	        }else {

	            throw new NotFoundException("No existe Mascota");
	        }
		
	}

	@Override
	public void deletePet(Long id) {
		 if(petdao.existsById(id)) {
	            petdao.deleteById(id);

	        }else {

	            throw new NotFoundException("Mascota no existe");
	        }
		
	}
	
	

	

}
