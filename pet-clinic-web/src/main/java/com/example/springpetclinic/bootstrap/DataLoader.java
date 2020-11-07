package com.example.springpetclinic.bootstrap;

import com.example.springpetclinic.model.*;
import com.example.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
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
        pet1.setPetType(savedPetType1);
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
        pet2.setPetType(savedPetType2);
        pet2.setOwner(owner2);
        pet2.setBirthday(LocalDate.now());
        pet2.setName("pet2");

        owner2.getPets().add(pet2);
        ownerService.save(owner2);

        Visit visit1 = new Visit();
        visit1.setPet(pet1);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("visit1 visited");

        visitService.save(visit1);

        System.out.println("Loaded owners ... ");


        Specialty specialty1 = new Specialty();
        specialty1.setDescription("speciality1");
        Specialty savedSpecialty1 = specialtyService.save(specialty1);

        Specialty specialty2 = new Specialty();
        specialty1.setDescription("speciality2");
        Specialty savedSpecialty2 = specialtyService.save(specialty2);

        Specialty specialty3 = new Specialty();
        specialty1.setDescription("speciality3");
        Specialty savedSpecialty3 = specialtyService.save(specialty3);


        Vet vet1 = new Vet();
        vet1.setFirstName("first Vet1");
        vet1.setLastName("last Vet1");

        vet1.getSpecialities().add(savedSpecialty1);
        vet1.getSpecialities().add(savedSpecialty2);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("first Vet2");
        vet2.setLastName("last Vet2");

        vet2.getSpecialities().add(savedSpecialty2);
        vet2.getSpecialities().add(savedSpecialty3);
        vetService.save(vet2);


        System.out.println("Loaded vets ... ");
    }
}
