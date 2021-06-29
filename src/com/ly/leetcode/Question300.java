package com.ly.leetcode;

/**
 * 状态转移方程：dp[i]=max(dp[j])+1 0<=j<i,nums[j]<nums[i]
 * 假设dp[i]一定包含nums[i]
 * @author ly.
 * @date 2021/4/25
 */
public class Question300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] =1;
        int ans = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
