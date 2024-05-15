package org.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LC122 {

    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int sum = 0;

        while (j < prices.length) {
            if (prices[j] > prices[i]) {
                sum += prices[j] - prices[i];
            }
            i++;
            j++;
        }
        return sum;
    }

    @Test
    public void TestMaxProfit() {
        assertEquals(7, new LC122().maxProfit(new int[]{ 7, 1, 5, 3, 6, 4}));
        assertEquals(4, new LC122().maxProfit(new int[]{ 1, 2, 3, 4, 5}));
    }

}
