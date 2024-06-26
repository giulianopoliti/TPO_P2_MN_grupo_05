package org.example.tdas;

public interface IGenericSet<T> {
    void add(T var1);

    void remove(T var1);

    boolean isEmpty();

    T choose();
}