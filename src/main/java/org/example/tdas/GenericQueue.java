package org.example.tdas;

import java.util.ArrayList;
import java.util.List;

public class GenericQueue<T> implements IGenericQueue<T> {
    private static final int MAX = 10000;
    private final List<T> array = new ArrayList(10000);
    private int count = 0;

    public GenericQueue() {
    }

    public void add(T item) {
        if (this.count >= 10000) {
            throw new RuntimeException("Limite excedido.");
        } else {
            this.array.add(item);
            ++this.count;
        }
    }

    public void remove() {
        if (this.count == 0) {
            throw new RuntimeException("No se puede desacolar una cola vacia.");
        } else {
            this.array.remove(this.count);
            --this.count;
        }
    }

    public T getFirst() {
        if (this.count == 0) {
            throw new RuntimeException("Error, no se puede obtener el primero de una cola vacia.");
        } else {
            return this.array.getFirst();
        }
    }

    public boolean isEmpty() {
        return this.array.isEmpty();
    }
}
