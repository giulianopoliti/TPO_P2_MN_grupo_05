package org.example.tdas;

public interface IGenericQueueWithPriority<T> { // Hecho por Simon Ottati
    void add(T var1, int var2);

    void remove();

    T getFirst();

    int getPriority();

    boolean isEmpty();
}
