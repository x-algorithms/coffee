package org.kylin.queue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListQueueTest {

    @Test
    void TestOffer() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertIterableEquals(Arrays.asList(1, 2, 3), queue);
    }

    @Test
    void poll() {
    }

    @Test
    void peek() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        assertEquals(1, queue.peek());
        queue.offer(8);
        assertEquals(1, queue.peek());
    }

    @Test
    void isEmpty() {
    }
}