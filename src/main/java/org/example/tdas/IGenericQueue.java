package org.example.tdas;


public interface IGenericQueue<T> { // Hecho por Simon Ottati
    void add(T var1);

    void remove();

    T getFirst();

    boolean isEmpty();
}
