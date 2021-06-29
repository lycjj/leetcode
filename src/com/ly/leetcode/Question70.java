package com.ly.leetcode;

/**
 * @author ly.
 * @date 2021/2/11
 */
public class Question70 {
    public static int climbStairs(int n) {
        int temp;
        int f1 = 1;
        int f2 = 1;
        for(int i = 1; i < n; i++) {
            temp = f2;
            f2+=f1;
            f1 = temp;
        }
        return f2;
    }

    public static void main(String[] args) {
        int result = climbStairs(3);
        System.out.println(result);
    }
}
