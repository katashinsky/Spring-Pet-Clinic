package com.example.springpetclinic.services;

import com.example.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends GrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
