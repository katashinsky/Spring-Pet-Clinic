package com.example.springpetclinic.services;

import java.util.Set;

public interface GrudService<T, ID> {

    public Set<T> findAll();

    public T findById(ID id);

    public T Save(T object);

    public void delete(T object);

    public void deleteById(ID id);
}
