package com.ly.leetcode;

/**
 * @author ly.
 * @date 2021/7/5
 */
public class Question45 {
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(new Question45().jump(nums));
    }
}
