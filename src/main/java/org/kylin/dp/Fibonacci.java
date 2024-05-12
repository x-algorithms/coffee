package org.kylin.dp;

import org.junit.Test;
import org.kylin.utils.ColorfulPrintUtil;
import static org.junit.Assert.assertEquals;

public class Fibonacci {

    /**
     * f0   f1  f2  f3  f4  f5  f6  f7  f8  f9  f10
     * 0    1   1   2   3   5   8   13  21  34  55
     */
    public static int fib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    @Test
    public void TestFib() {
        int res = fib(10);
        assertEquals(55, res);
    }
}
