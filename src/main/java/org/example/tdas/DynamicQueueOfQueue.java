package org.example.tdas;

import java.util.Objects;

public class DynamicQueueOfQueue implements IQueueOfQueue {
    private GenericNode<DynamicQueue> first;

    public DynamicQueueOfQueue() {
    }

    public void add(DynamicQueue q) {
        GenericNode<DynamicQueue> genNode = new GenericNode(q, this.first);
        this.first = genNode;
    }

    public DynamicQueueOfQueue concatenate(DynamicQueueOfQueue... queues) {
        DynamicQueueOfQueue result = new DynamicQueueOfQueue();
        DynamicQueueOfQueue[] var3 = queues;
        int var4 = queues.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            DynamicQueueOfQueue queueOfQueue = var3[var5];
            DynamicQueue flatQueue = queueOfQueue.flat();
            result.add(flatQueue);
        }

        return result;
    }

    public DynamicQueue flat() {
        DynamicQueue flatQueue = new DynamicQueue();
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede usar el metodo Flat en una Queue of Queues vacia.");
        } else {
            for(GenericNode<DynamicQueue> current = this.first; current != null; current = current.getNext()) {
                DynamicQueue currentQueue = (DynamicQueue)current.getValue();

                while(!currentQueue.isEmpty()) {
                    flatQueue.add(currentQueue.getFirst());
                    currentQueue.remove();
                }
            }

            return flatQueue;
        }
    }

    private GenericNode<DynamicQueue> getLast() {
        GenericNode current;
        for(current = this.first; current.getNext() != null; current = current.getNext()) {
        }

        return current;
    }

    private boolean isEmpty() {
        return Objects.isNull(this.first);
    }

    public void reverseWithDepth() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede usar el metodo reverseWithDepth en una Queue of Queues vacia.");
        } else {
            GenericDynamicStack<GenericNode<DynamicQueue>> stack = new GenericDynamicStack();

            GenericNode current;
            for(current = this.first; current != null; current = current.getNext()) {
                stack.add(current);
            }

            this.first = (GenericNode)stack.getTop();
            stack.remove();
            current = this.first;

            while(!stack.isEmpty()) {
                GenericNode<DynamicQueue> node = (GenericNode)stack.getTop();
                current.setNext(node);
                current = node;
                stack.remove();
                node.setNext((GenericNode)null);
            }

            for(current = this.first; current != null; current = current.getNext()) {
                this.reverseQueue((DynamicQueue)current.getValue());
            }

        }
    }

    private void reverseQueue(DynamicQueue queue) {
        IStack stack = new Stack();

        while(!queue.isEmpty()) {
            stack.add(queue.getFirst());
            queue.remove();
        }

        while(!stack.isEmpty()) {
            queue.add(stack.getTop());
            stack.remove();
        }

    }
}
