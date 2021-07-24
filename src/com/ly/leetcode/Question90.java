package com.ly.leetcode;

import java.util.*;

/**
 * @author ly.
 * @date 2021/7/24
 */
public class Question90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Map<String, String> map = new HashMap<String, String>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        int length = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        result.add(list);
        int num;
        int index;
        StringBuilder str;
        for (int i = 1; i < Math.pow(2, length); i++) {
            list = new ArrayList<Integer>();
            num = i;
            index = length - 1;
            while (num > 0) {
                if ((num & 1) != 0) {
                    if (index < length) {
                        list.add(nums[index]);
                    }
                }
                num = num >> 1;
                index--;
            }
            str = new StringBuilder();
            for(int j : list)
            {
                str.append(j);
                str.append("-");
            }
            if(!map.containsKey(str.toString())) {
                result.add(list);
                map.put(str.toString(),str.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,8,10};
        List<List<Integer>> result = new Question90().subsetsWithDup(nums);
        System.out.println(result);
    }
}
