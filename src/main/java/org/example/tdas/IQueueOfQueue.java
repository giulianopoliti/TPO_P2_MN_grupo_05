package org.example.tdas;

public interface IQueueOfQueue { // Hecho por Simon Ottati
    DynamicQueueOfQueue concatenate(DynamicQueueOfQueue... var1);

    DynamicQueue flat();

    void reverseWithDepth();
}

