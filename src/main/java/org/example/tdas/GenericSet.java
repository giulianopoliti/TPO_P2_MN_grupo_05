package org.example.tdas;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenericSet<T> implements IGenericSet<T> {
    private static final int MAX = 10000;
    private List<T> array = new ArrayList(10000);
    private int count = 0;

    public GenericSet() {
    }

    public void add(T item) {
        if (this.count == 10000) {
            throw new RuntimeException("Limite de elementos alcanzado.");
        } else {
            for(int i = 0; i < this.count; ++i) {
                if (this.array.get(i) == item) {
                    return;
                }
            }

            this.array.add(item);
            ++this.count;
        }
    }

    public void remove(T item) {
        for(int i = 0; i < this.count; ++i) {
            if (this.array.get(i) == item) {
                this.array.remove(item);
                --this.count;
                return;
            }
        }

    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public T choose() {
        if (this.count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vacio.");
        } else {
            return this.array.get((new Random()).nextInt(this.count));
        }
    }
}
