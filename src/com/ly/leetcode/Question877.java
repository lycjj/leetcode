package com.ly.leetcode;

/**
 * 思路：动态规划
 * @author ly.
 * @date 2021/6/16
 */
public class Question877 {
    public static boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for(int i = 0; i < dp.length; i++) {
            dp[i][i] = piles[i];
        }

        for(int i = piles.length-2; i >=0; i--) {
            for(int j = i+1; j <piles.length;j++) {
                dp[i][j] = Math.max((piles[i]-dp[i+1][j]),(piles[j]-dp[i][j-1]));
            }
        }
        return dp[0][piles.length-1] > 0;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,10,4};
        System.out.println(stoneGame(arr));
    }
}
