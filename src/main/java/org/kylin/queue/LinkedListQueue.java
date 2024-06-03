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
    Node<E> head = new Node<>(null, null);
    Node<E> tail = head;

    public LinkedListQueue() {
        tail.next = head;
    }


    @Override
    public boolean offer(E value) {
        Node<E> newNode = new Node<>(value, head);
        tail.next = newNode;
        tail = newNode;
        return true;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;

            // 单向环形链表
            // p.next = head 则首位相邻
            @Override
            public boolean hasNext() {
                return p != head;
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
