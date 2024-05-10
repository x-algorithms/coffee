package org.kylin.recursion;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * multi recursion
 */
public class Fibonacci {

    public static int F(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return F(n - 1) + F(n - 2);
    }

    @Test
    public void TestFibonacci() {
        int ant = F(8);
        assertEquals(21, ant);

        int bear = F(11);
        assertEquals(89, bear);

        int cat = F(12);
        assertEquals(144, cat);
    }

    /**
     * Memorization
     */
    public static int fib(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return ff(n, cache);
    }

    public static int ff(int n, int[] cache) {
        if (cache[n] != -1) {
            return cache[n];
        }

        cache[n] = ff(n - 1, cache) + ff(n - 2, cache);
        return cache[n];
    }


    @Test
    public void TestFib() {
        assertEquals(1, fib(2));
        assertEquals(2, fib(3));
        assertEquals(3, fib(4));
        assertEquals(5, fib(5));
        assertEquals(8, fib(6));
        assertEquals(13, fib(7));
        assertEquals(21, fib(8));
        assertEquals(34, fib(9));
        assertEquals(55, fib(10));
        assertEquals(89, fib(11));
        assertEquals(144, fib(12));
    }
}
