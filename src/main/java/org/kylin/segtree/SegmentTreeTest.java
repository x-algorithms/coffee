package org.kylin.segtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SegmentTreeTest {
    Integer[] nums = {-2, 0, 3, -5, 2, -1};
    SegmentTree<Integer> segTree = new SegmentTree<>(nums, (a, b) -> a + b);

    @Test
    public void testCreateSegmentTree() {
        System.out.println(segTree);
    }

    @Test
    public void testQuery() {
        int ant = segTree.query(0, 2);
        assertEquals(1, ant);

        int bear = segTree.query(0, 5);
        assertEquals(-3, bear);

        int cat = segTree.query(2, 5);
        assertEquals(-1, cat);

        int dog = segTree.query(4, 5);
        assertEquals(1, dog);
    }


}
