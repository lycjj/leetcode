package com.ly.leetcode;

/**
 * @author ly.
 * @date 2021/2/17
 */
public class Question5 {
    public static String longestPalindrome(String s) {
        int j;
        String ans = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
                if(dp[i][j] && l+1 > ans.length()) {
                    ans = s.substring(i,j+1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
