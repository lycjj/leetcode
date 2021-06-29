package com.ly.leetcode;

/**
 * @author ly.
 * @date 2021/6/17
 */
public class Question75 {
    public void sortColors(int[] nums) {
        int pointOne = 0,pointTwo = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                swap(nums, pointTwo, i);
                pointTwo++;
            } else if(nums[i] == 0) {
                swap(nums,pointOne,i);
                // 如果pointOne小于pointTwo,说明此时pointOne指向1,所以需要pointTwo和i再交换一次
                if(pointOne < pointTwo) {
                    swap(nums,pointTwo,i);
                }
                pointOne++;
                pointTwo++;
            }
        }
    }

    public void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
