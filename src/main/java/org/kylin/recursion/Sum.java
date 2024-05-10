package org.kylin.recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Sum {

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    @Test
    public void TestSum() {
        assertEquals(6, sum(3));
        assertEquals(10, sum(4));
        assertEquals(15, sum(5));
    }

    @Test
    public void TestSumStackOverflow() {
        // java.lang.StackOverflowError
        int result = sum(1000000);
        System.out.println(result);
    }
}
