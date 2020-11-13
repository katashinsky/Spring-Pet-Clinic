package com.example.springpetclinic.services.springdatajpa;

import com.example.springpetclinic.model.Owner;
import com.example.springpetclinic.repositories.OwnerRepository;
import com.example.springpetclinic.repositories.PetRepository;
import com.example.springpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    final Long ownerId = 1l;
    final String ownerLastName = "Smith";

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(ownerId).lastName(ownerLastName).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner smith = ownerSDJpaService.findByLastName(ownerLastName);
        assertEquals(ownerLastName, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1l).build());
        ownerSet.add(Owner.builder().id(2l).build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = ownerSDJpaService.findAll();
        assertEquals(2, owners.size());

        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));
        Owner owner = ownerSDJpaService.findById(ownerId);

        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        Owner owner = ownerSDJpaService.findById(3l);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(ownerId).build();
        when(ownerRepository.save(any())).thenReturn(owner);

        Owner savedOwner = ownerSDJpaService.save(owner);
        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(ownerId);

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}