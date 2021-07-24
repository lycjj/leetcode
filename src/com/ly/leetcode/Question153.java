package com.ly.leetcode;

/**
 * @author ly.
 * @date 2021/7/23
 * 优化：使用二分法
 */
public class Question153 {
    public int findMin(int[] nums) {
        int result = 0;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i - 1] > nums[i]) {
                result = nums[i];
                flag = true;
                break;
            }
        }
        if(!flag) {
            return nums[0];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,1};
        System.out.println(new Question153().findMin(arr));
    }
}
