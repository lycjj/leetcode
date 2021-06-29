package com.ly.leetcode;

/**
 * @author ly.
 * @date 2021/2/8
 */
public class Question136 {
    public static int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int temp;
        boolean resultFlag;
        for(int i = 0; i < nums.length; i++) {
            resultFlag = true;
            temp = nums[i];
            for(int j = 0; j < nums.length; j++) {
                if(i != j && temp == nums[j]) {
                    resultFlag = false;
                    break;
                }

            }
            if(resultFlag) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {4,1,2,1,2};
        int result = singleNumber(array);
        System.out.println(result);
    }
}
