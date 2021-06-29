package com.ly.leetcode;

/**
 * @author ly.
 * @date 2021/4/28
 */
public class Question279 {
    public static int numSquares(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        if(isPerfectSquare(n)) {
            return 1;
        }
        int min;
        for(int i = 3; i <= n; i++) {
            if(isPerfectSquare(i)) {
                dp[i] = 1;
            } else{
                min = Integer.MAX_VALUE;
                for(int j = 1; j <= (i/2); j++) {
                    if((dp[j]+dp[i-j]) < min) {
                        min = dp[j]+dp[i-j];
                    }
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }

    public static boolean isPerfectSquare(long n)
    {
        if (n < 0) {
            return false;
        }

        long tst = (long)(Math.sqrt(n) + 0.5);
        return tst*tst == n;
    }
    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
}
