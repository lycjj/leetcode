package com.ly.leetcode;

/**
 * 思路：运用贪心算法
 * @author ly.
 * @date 2021/6/28
 */
public class Question55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i)
        {
            if (i <= rightmost)
            {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
