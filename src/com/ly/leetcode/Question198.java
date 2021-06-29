package com.ly.leetcode;

/**
 * @author ly.
 * @date 2021/4/24
 */
public class Question198 {
    public static int rob(int[] nums) {
        if(nums == null || nums.length <=0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
       int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1]  = Math.max(nums[0],nums[1]);
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] array  = {1,2,3,1};
        System.out.println(rob(array));
    }
}
