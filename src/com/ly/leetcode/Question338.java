package com.ly.leetcode;

/**
 * @author ly.
 * @date 2021/5/9
 */
public class Question338 {
    public static int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        if(num <= 0) {
            return result;
        }
        result[1] = 1;
        for(int i = 2;i <= num; i++) {
            if(i%2 == 1) {
                result[i] = result[i/2]+1;
            } else {
                result[i] = result[i/2];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = countBits(0);
        System.out.println(result);
    }
}
