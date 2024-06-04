package org.kylin.deque;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class DequeListTest {

    @Test
    void offerFirst() {
        DequeList<Integer> dequeList = new DequeList<>(3);
        dequeList.offerFirst(3);
        dequeList.offerFirst(2);
        dequeList.offerFirst(1);
        assertFalse(dequeList.offerFirst(4));
        assertIterableEquals(Arrays.asList(1, 2, 3), dequeList);
    }

    @Test
    void offerLast() {
        DequeList<Integer> dequeList = new DequeList<>(3);
        dequeList.offerLast(3);
        dequeList.offerLast(2);
        dequeList.offerLast(1);
        assertFalse(dequeList.offerFirst(4));
        assertIterableEquals(Arrays.asList(3, 2, 1), dequeList);
    }

    @Test
    void pollFirst() {
        DequeList<Integer> dequeList = new DequeList<>(3);
        dequeList.offerFirst(3);
        dequeList.offerFirst(2);
        dequeList.offerFirst(1);
        assertEquals(1, dequeList.pollFirst());
        assertEquals(2, dequeList.pollFirst());
        assertEquals(3, dequeList.pollFirst());
        assertNull(dequeList.pollFirst());
    }

    @Test
    void pollLast() {
        DequeList<Integer> dequeList = new DequeList<>(3);
        dequeList.offerLast(3);
        dequeList.offerLast(2);
        dequeList.offerLast(1);
        assertEquals(1, dequeList.pollLast());
        assertEquals(2, dequeList.pollLast());
        assertEquals(3, dequeList.pollLast());
        assertNull(dequeList.pollLast());
    }

    @Test
    void peekFirst() {
        DequeList<Integer> dequeList = new DequeList<>(3);
        dequeList.offerFirst(3);
        dequeList.offerFirst(2);
        dequeList.offerFirst(1);
        assertEquals(1, dequeList.peekFirst());
        dequeList.pollFirst();
        assertEquals(2, dequeList.peekFirst());
        dequeList.pollFirst();
        assertEquals(3, dequeList.pollFirst());
        dequeList.pollFirst();
        assertNull(dequeList.pollFirst());
    }

    @Test
    void peekLast() {
        DequeList<Integer> dequeList = new DequeList<>(3);
        dequeList.offerFirst(3);
        dequeList.offerFirst(2);
        dequeList.offerFirst(1);
        assertEquals(3, dequeList.peekLast());
        dequeList.pollLast();
        assertEquals(2, dequeList.peekLast());
        dequeList.pollLast();
        assertEquals(1, dequeList.peekLast());
        dequeList.pollLast();
        assertNull(dequeList.pollLast());
    }

    @Test
    void isEmpty() {
        DequeList<Integer> dequeList = new DequeList<>(3);
        dequeList.offerFirst(3);
        dequeList.offerFirst(2);
        assertNotNull(dequeList);
        assertEquals(3, dequeList.pollLast());
        assertEquals(2, dequeList.pollFirst());
        assertNull(dequeList.pollFirst());
    }

    @Test
    void isFull() {
        DequeList<Integer> dequeList = new DequeList<>(2);
        dequeList.offerFirst(3);
        dequeList.offerFirst(2);
        assertEquals(true, dequeList.isFull());
        assertFalse(dequeList.offerFirst(1));
    }

    @Test
    void iterator() {
    }
}