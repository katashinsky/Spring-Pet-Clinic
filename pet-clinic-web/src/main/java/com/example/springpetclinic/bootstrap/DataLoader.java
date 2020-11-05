package com.example.springpetclinic.bootstrap;

import com.example.springpetclinic.model.Owner;
import com.example.springpetclinic.model.Pet;
import com.example.springpetclinic.model.PetType;
import com.example.springpetclinic.model.Vet;
import com.example.springpetclinic.services.OwnerService;
import com.example.springpetclinic.services.PetTypeService;
import com.example.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("address_111");
        owner1.setCity("city_1");
        owner1.setTelephone("111111111");


        Pet pet1 = new Pet();
        pet1.setPetType(petType1);
        pet1.setOwner(owner1);
        pet1.setBirthday(LocalDate.now());
        pet1.setName("pet1");

        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("first Owner2");
        owner2.setLastName("last Owner2");
        owner2.setAddress("address_222");
        owner2.setCity("city_2");
        owner2.setTelephone("222222222");


        Pet pet2 = new Pet();
        pet2.setPetType(petType2);
        pet2.setOwner(owner2);
        pet2.setBirthday(LocalDate.now());
        pet2.setName("pet2");

        owner2.getPets().add(pet2);
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
