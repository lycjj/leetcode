package com.ly.leetcode;

/**
 * 0-1背包问题，求解从一个数组中选取几个数，使得数之和为neg,neg尽可能地大,并且neg<sum/2
 * @author ly.
 * @date 2021/6/9
 */
public class Question1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int num : stones) {
            sum += num;
        }
        int n = stones.length;
        int m = sum / 2;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (stones[i] > j) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = dp[i][j] || dp[i][j - stones[i]];
                }
            }
        }
        for (int j = m; j >= 0; j--) {
            if (dp[n][j]) {
                return sum - 2 * j;
            }
        }
        return 0;
    }
}
