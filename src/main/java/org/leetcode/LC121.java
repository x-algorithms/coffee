package org.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LC121 {

    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int max = 0;

        while (j < prices.length) {
            // Up
            if (prices[j] > prices[i]) {
                max = Math.max(max, prices[j] - prices[i]);
                j++;
            } else {
                // down
                i = j;
                j++;
            }
        }
        return max;
    }

    @Test
    public void TestMaxProfit() {
        assertEquals(5, new LC121().maxProfit(new int[]{ 7, 1, 5, 3, 6, 4}));
        assertEquals(0, new LC121().maxProfit(new int[]{ 7, 6, 4, 3, 1}));
    }

}
