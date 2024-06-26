package org.example.tdas;


import java.util.ArrayList;
import java.util.List;

public class GenericStack<T> implements IGenericStack<T> { // Hecho por Simon Ottati
    private static final int MAX = 10000;
    private final List<T> array = new ArrayList(10000);
    private int count = 0;

    public GenericStack() {
    }

    public void add(T item) {
        if (this.count >= 10000) {
            throw new RuntimeException("Limite excedido,");
        } else {
            this.array.add(item);
            ++this.count;
        }
    }

    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pila generica vacia. No se puede remover.");
        } else {
            this.array.remove(this.count - 1);
            --this.count;
        }
    }

    public T getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pila vacia. No se puede obtener el tope.");
        } else {
            return this.array.get(this.count - 1);
        }
    }

    public boolean isEmpty() {
        return this.count == 0;
    }
}
