package com.ly.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：先排序，再去重，再双指针
 * 解法二：哈希表
 *
 * @author ly.
 * @date 2021/7/17
 */
public class Question128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        list.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == list.get(list.size()-1)) {
                continue;
            }
            list.add(nums[i]);
        }
        if(list.size() == 1) {
            return 1;
        }
        int startIndex = 0, endIndex = 0;
        int max = Integer.MIN_VALUE;
        while (endIndex < list.size() - 1) {
            if (list.get(endIndex) + 1 == list.get(endIndex + 1)) {
                endIndex++;
                if (endIndex == list.size() - 1) {
                    max = Math.max(max, endIndex - startIndex + 1);
                }
            } else {
                max = Math.max(max, endIndex - startIndex + 1);
                endIndex++;
                startIndex = endIndex;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0,0};
        System.out.println(new Question128().longestConsecutive(nums));
    }
}
