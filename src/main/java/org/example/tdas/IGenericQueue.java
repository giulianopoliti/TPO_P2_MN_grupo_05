package org.example.tdas;


public interface IGenericQueue<T> {
    void add(T var1);

    void remove();

    T getFirst();

    boolean isEmpty();
}
