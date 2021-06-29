package com.ly.leetcode;

/**
 * @author ly.
 * @date 2021/6/14
 */
public class Question374 {
    public int guessNumber(int n) {
        int left = 1,right = n;
        /*int mid;
        while(left < right) {
            mid = left + (right-left)/2;
            if(guess(mid) < 0) {
                right = mid;
            } else if(guess(mid) > 0) {
                left = mid;
            }
        }*/
        return left;
    }
}
