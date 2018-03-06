package net.chemodurov.projectmanagement.dao;


import java.util.Set;

public interface GenericDAO<T,ID> {
    void insert(T entity); //create
    T getById(ID id); //read
    void update(T entity); //update
    void delete(ID id); //delete
    Set<T> getAll(); //getAll
}

