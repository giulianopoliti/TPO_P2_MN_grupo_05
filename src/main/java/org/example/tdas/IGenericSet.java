package org.example.tdas;

public interface IGenericSet<T> { // Hecho por Simon Ottati
    void add(T var1);

    void remove(T var1);

    boolean isEmpty();

    T choose();
}