package com.ly.leetcode;

/**
 * 背包问题类似的问题
 *容量有两个，所以dp是三维数组
 * @author ly.
 * @date 2021/6/7
 */
public class Question474 {
    public static int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length, zeros, ones;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        char[] charArray;
        for (int i = 0; i < length; i++) {
            charArray = strs[i].toCharArray();
            zeros = ones = 0;
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] == '0') {
                    zeros++;
                }
                if (charArray[j] == '1') {
                    ones++;
                }
            }
            for (int k = 0; k <= m; k++) {
                for (int x = 0; x <= n; x++) {
                    if(zeros > k || ones > x) {
                        dp[i+1][k][x] = dp[i][k][x];
                    } else {
                        dp[i+1][k][x] = Math.max(dp[i][k][x],dp[i][k-zeros][x-ones]+1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    public static void main(String[] args) {
        String[] arr = {"10","0","1"};
        System.out.println(findMaxForm(arr,1,1));
    }
}
