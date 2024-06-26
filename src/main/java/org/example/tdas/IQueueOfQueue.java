package org.example.tdas;

public interface IQueueOfQueue {
    DynamicQueueOfQueue concatenate(DynamicQueueOfQueue... var1);

    DynamicQueue flat();

    void reverseWithDepth();
}

