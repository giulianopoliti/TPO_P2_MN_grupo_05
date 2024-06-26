package org.example.tdas;

public interface IQueueOfStacks {
    void add(int a);

    void remove();

    int getFirst();

    boolean isEmpty();
    int getNumElementsOfStack(); // no me quedo otra que hacer este metodo, para limitar los numeros

}
