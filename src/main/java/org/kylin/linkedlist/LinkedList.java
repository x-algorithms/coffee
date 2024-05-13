package org.kylin.linkedlist;

import org.kylin.utils.ColorfulPrintUtil;

public class LinkedList {

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


}
