package org.example.tdas;


import java.util.Objects;

public class GenericDynamicStack<T> implements IGenericStack<T> {
    private GenericNode<T> first;

    public GenericDynamicStack() {
    }

    public void add(T value) {
        GenericNode<T> node = new GenericNode(value, this.first);
        this.first = node;
    }

    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        } else {
            this.first = this.first.getNext();
        }
    }

    public T getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("No hay topes, esta vacia.");
        } else {
            return this.first.getValue();
        }
    }

    public boolean isEmpty() {
        return Objects.isNull(this.first);
    }
}