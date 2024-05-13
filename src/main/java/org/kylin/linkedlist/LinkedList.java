package org.kylin.linkedlist;

import org.kylin.utils.ColorfulPrintUtil;

import java.util.Iterator;

public class LinkedList implements Iterable<Integer> {
    class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head = null;

    public void prepend(int value) {
        head = new Node(value, head);
    }

    public void traversal() {
        Node p = head;

        while (p != null) {
            ColorfulPrintUtil.printCyan(p.value + "\t");
            p = p.next;
        }
    }

    public void loop() {
        for (Node p = head; p != null; p = p.next) {
            ColorfulPrintUtil.printYellow(p.value + "\t");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int val = p.value;
                p = p.next;
                return val;
            }
        };
    }

    public Node findLast() {
        if (head == null) {
            return null;
        }

        Node p;
        for (p = head; p.next != null; p = p.next) {}
        return p;
    }

    public void append(int value) {
        Node last = findLast();
        if (last == null) {
            prepend(value);
            return;
        }

        last.next = new Node(value, null);
    }

}
