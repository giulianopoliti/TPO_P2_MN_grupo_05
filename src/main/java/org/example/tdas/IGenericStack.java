package org.example.tdas;

public interface IGenericStack<T> { // Hecho por Simon Ottati
    void add(T var1);

    void remove();

    T getTop();

    boolean isEmpty();
}