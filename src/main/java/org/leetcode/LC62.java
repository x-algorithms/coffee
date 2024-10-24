package org.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <H1>62. 不同路径</H1>
 * <a href="https://leetcode.cn/problems/unique-paths/description/">题目</a>
 */
public class LC62 {

    public int uniquePaths(int m, int n) {
        // 1. dp array. m * n
        int[][] dp = new int[m][n];

        // 2. init value
        // column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // row
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // 3. calculate
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 上述用二维数组本质上很大空间是浪费的
     * 只需要最后一行空间即可满足计算存储需求
     */
    public int uniquePaths2(int m, int n) {
        // 1. dp array. m * n
        int[] dp = new int[n];

        // 2. init value
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }

        // 3. calculate
        for (int i = 1; i < m; i++) {
            dp[0] = 1;
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }


    @Test
    public void TestUniquePaths() {
        int ant = new LC62().uniquePaths(3, 7);
        assertEquals(28, ant);

        int bear = new LC62().uniquePaths(3, 2);
        assertEquals(3, bear);

        int cat = new LC62().uniquePaths(3, 3);
        assertEquals(6, cat);
    }

    @Test
    public void TestUniquePaths2() {
        int ant = new LC62().uniquePaths2(3, 7);
        assertEquals(28, ant);

        int bear = new LC62().uniquePaths2(3, 2);
        assertEquals(3, bear);

        int cat = new LC62().uniquePaths2(3, 3);
        assertEquals(6, cat);
    }
}
