package org.kylin.heap;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    public E getFront() {
        return maxHeap.getMax();
    }

    public void enqueue(E e) {
        maxHeap.add(e);
    }

    public E dequeue() {
        return maxHeap.extractMax();
    }
}
