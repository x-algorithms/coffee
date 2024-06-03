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
    void TestPoll() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(11);
        queue.offer(21);
        queue.offer(38);

        assertEquals(11, queue.poll());
        assertEquals(21, queue.poll());
        assertEquals(38, queue.poll());
        assertNull(queue.poll());
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