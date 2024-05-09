package org.kylin.recursion;

import org.junit.Test;
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
}
