package org.kylin.linkedlist;

import org.junit.Test;
import org.kylin.utils.ColorfulPrintUtil;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void prepend() {
        LinkedList linkedList = new LinkedList();
        linkedList.prepend(1);
        linkedList.prepend(2);
        linkedList.prepend(3);
        linkedList.prepend(4);
        linkedList.prepend(5);
        linkedList.traversal();

        System.out.println();
        linkedList.loop();

        System.out.println();
        for (Integer value: linkedList) {
            ColorfulPrintUtil.printGreen(value + "\t");
        }
    }


}