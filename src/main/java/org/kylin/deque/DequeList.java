package org.kylin.deque;

import java.util.Iterator;

/**
 * 使用双向环形链表来实现
 * @param <E>
 */
public class DequeList<E> implements Deque<E>, Iterable<E> {

    static class Node<E> {
        Node<E> prev;
        Node<E> next;
        E value;

        public Node(Node<E> prev, Node<E> next, E value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    int size;
    int capacity;
    Node<E> dummyNode = new Node<>(null, null, null);

    public DequeList(int capacity) {
        this.capacity = capacity;
        dummyNode.next = dummyNode;
        dummyNode.prev = dummyNode;
    }

    @Override
    public boolean offerFirst(E value) {
        return false;
    }

    @Override
    public boolean offerLast(E value) {
        return false;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
