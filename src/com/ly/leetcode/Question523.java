package com.ly.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * i思路：前缀和加上哈希表
 * (p+1,q) = nums[q]-nums[p+1]
 * nums[q]-nums[p+1]是k的倍数等价于二者对k的余数相等
 * @author ly.
 * @date 2021/6/3
 */
public class Question523 {
    public static boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null) {
            return false;
        }
        int[] preNums = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++) {
            preNums[i+1] = preNums[i]+nums[i];
        }
        Map<Integer,Integer> remainNums = new HashMap<Integer,Integer>();
        remainNums.put(0,0);
        int remain;
        for(int i = 1; i < preNums.length; i++) {
            remain = preNums[i]%k;
            if(!remainNums.containsKey(remain)) {
                remainNums.put(remain,i);
            } else {
                if(i-(remainNums.get(remain)) >=2){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23,2,6,4,7};
        System.out.println(checkSubarraySum(nums,13));
    }
}
