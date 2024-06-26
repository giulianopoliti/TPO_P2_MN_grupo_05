package org.example.tdas;

public interface IGenericStack<T> {
    void add(T var1);

    void remove();

    T getTop();

    boolean isEmpty();
}