package org.example.tdas;

public class GenericNode <T> { // Hecho por Simon Ottati
    private T value;
    private GenericNode<T> next;

    public GenericNode(T value, GenericNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public GenericNode getNext() {
        return this.next;
    }

    public void setNext(GenericNode<T> next) {
        this.next = next;
    }

}
