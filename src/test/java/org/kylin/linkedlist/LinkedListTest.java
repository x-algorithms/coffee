package org.kylin.linkedlist;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.kylin.utils.ColorfulPrintUtil;
import java.util.Arrays;

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


    @Test
    public void append() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.traversal();

        Assertions.assertIterableEquals(Arrays.asList(1, 2, 3, 4), linkedList);
    }

}