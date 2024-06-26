package org.example.tdas;


import java.util.ArrayList;
import java.util.List;

public class GenericQueueWithPriority<T> implements IGenericQueueWithPriority<T> { // Hecho por Simon Ottati
    private static final int LENGHT = 10000;
    private final List<T> array = new ArrayList(10000);
    private final int[] priorities = new int[10000];
    private int count = 0;

    public GenericQueueWithPriority() {
    }

    public void add(T item, int priority) {
        int index = this.binarySearch(priority);

        for(int i = this.count; i > index; --i) {
            this.array.set(i, this.array.get(i + 1));
            this.priorities[i] = this.priorities[i + 1];
        }

        this.array.set(index, item);
        this.priorities[index] = priority;
        ++this.count;
    }

    private int binarySearch(int priority) {
        int low = 0;
        int high = this.count - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if (this.priorities[mid] == priority) {
                return mid;
            }

            if (this.priorities[mid] < priority) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public void remove() {
        if (this.count == 0) {
            throw new RuntimeException("Error, no se puede desacolar una cola vacia.");
        } else {
            for(int i = 0; i < this.array.size() - 1; ++i) {
                this.array.set(i, this.array.get(i + 1));
                this.priorities[i] = this.priorities[i + 1];
            }

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

    public int getPriority() {
        if (this.count == 0) {
            throw new RuntimeException("Error, no se puede obtener el primero de una cola vacia.");
        } else {
            return this.priorities[0];
        }
    }

    public boolean isEmpty() {
        return this.count == 0;
    }
}

