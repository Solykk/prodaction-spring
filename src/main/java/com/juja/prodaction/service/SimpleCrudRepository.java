package com.juja.prodaction.service;

import java.io.Serializable;

/**
 * @author Dmitriy Lyashenko
 */
public interface SimpleCrudRepository<T, ID extends Serializable> {

    T create(T object);
    T read(ID id);
    Iterable<T> readAll();
    T update(T object);
    void delete(ID id);

}
