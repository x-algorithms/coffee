package org.kylin.queue;

import java.util.Iterator;

/**
 * 使用单向环形链表实现队列
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // dummy head
    // 初始化时首尾指向虚拟节点
    Node<E> dummyHead = new Node<>(null, null);
    Node<E> tail = dummyHead;

    public LinkedListQueue() {
        tail.next = dummyHead;
    }


    @Override
    public boolean offer(E value) {
        Node<E> newNode = new Node<>(value, dummyHead);
        tail.next = newNode;
        tail = newNode;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        Node<E> head = dummyHead.next;
        dummyHead.next = head.next;
        if (head == tail) {
            tail = head;
        }
        return head.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return dummyHead.next.value;
    }

    @Override
    public boolean isEmpty() {
        return dummyHead == tail;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = dummyHead.next;

            // 单向环形链表
            // p.next = head 则首位相邻
            @Override
            public boolean hasNext() {
                return p != dummyHead;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
