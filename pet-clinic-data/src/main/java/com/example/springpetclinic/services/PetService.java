package com.example.springpetclinic.services;

import com.example.springpetclinic.model.Owner;
import com.example.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByName(String name);

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
