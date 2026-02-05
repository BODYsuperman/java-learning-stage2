package com.alex.d9_generic_interface;

public interface Data<T> {
    void Add(T t);
    void delete(T t);
    void update(T t);
    T getById(int id);
}
