package com.ly.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ly.
 * @date 2021/6/3
 */
public class Question525 {
    public static int findMaxLength(int[] nums) {
        if(nums == null || nums.length <= 0) {
            return 0;
        }
        Map<Integer,Integer> subtractMap = new HashMap<Integer,Integer>();
        int[] subtractArray = new int[nums.length+1];
        for(int i = 1; i <= nums.length; i++) {
            if(nums[i-1] == 0) {
                subtractArray[i] = subtractArray[i-1] -1;
            } else {
                subtractArray[i] = subtractArray[i-1]+1;
            }
        }
        int max = 0;
        for(int i = 0; i < subtractArray.length; i++) {
            if(!subtractMap.containsKey(subtractArray[i])) {
                subtractMap.put(subtractArray[i],i);
            } else {
                if(max < (i-subtractMap.get(subtractArray[i]))) {
                    max = i-subtractMap.get(subtractArray[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0};
        System.out.println(findMaxLength(nums));
    }
}
