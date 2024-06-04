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

    /**
     * dummy new last
     * @param value 添加节点值
     * @return 是否添加成功
     */
    @Override
    public boolean offerFirst(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> dummyHead = dummyNode;
        Node<E> last = dummyNode.next;
        Node<E> newNode = new Node<>(dummyHead, last, value);
        dummyHead.next = newNode;
        last.prev = newNode;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> first = dummyNode.prev;
        Node<E> last = dummyNode;
        Node<E> newNode = new Node<>(first, last, value);
        first.next = newNode;
        last.prev = newNode;
        size++;
        return true;
    }

    /**
     * first removed last, first 就是虚拟节点，那么removed 就是头部第一个节点
     * @return 被移除节点值
     */
    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> first = dummyNode;
        Node<E> removedNode = dummyNode.next;
        Node<E> last = removedNode.next;
        first.next = last;
        last.prev = first;
        size--;
        return removedNode.value;
    }

    /**
     * 双端队列尾部移除元素
     * first removedNode last, last 是虚拟节点，那么removedNode 就是真实的最后一个节点
     * @return 双端队列最后一个元素值
     */
    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> last = dummyNode;
        Node<E> removedNode = dummyNode.prev;
        Node<E> first = removedNode.prev;
        first.next = last;
        last.prev = first;
        size--;
        return removedNode.value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return dummyNode.next.value;
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return dummyNode.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> head = dummyNode.next;
            @Override
            public boolean hasNext() {
                return head != dummyNode;
            }

            @Override
            public E next() {
                E value = head.value;
                head = head.next;
                return value;
            }
        };
    }
}
