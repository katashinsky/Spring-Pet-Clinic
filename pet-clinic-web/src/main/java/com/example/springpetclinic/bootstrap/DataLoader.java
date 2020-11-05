package com.example.springpetclinic.bootstrap;

import com.example.springpetclinic.model.Owner;
import com.example.springpetclinic.model.PetType;
import com.example.springpetclinic.model.Vet;
import com.example.springpetclinic.services.OwnerService;
import com.example.springpetclinic.services.PetTypeService;
import com.example.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType petType1 = new PetType();
        petType1.setName("petType1");
        PetType savedPetType1 = petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType1.setName("petType2");
        PetType savedPetType2 = petTypeService.save(petType2);

        Owner owner1 = new Owner();
        owner1.setFirstName("first Owner1");
        owner1.setLastName("last Owner1");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setFirstName("first Owner2");
        owner1.setLastName("last Owner2");
        ownerService.save(owner2);

        System.out.println("Loaded owners ... ");

        Vet vet1 = new Vet();
        vet1.setFirstName("first Vet1");
        vet1.setLastName("last Vet1");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("first Vet2");
        vet2.setLastName("last Vet2");
        vetService.save(vet2);


        System.out.println("Loaded vets ... ");
    }
}
