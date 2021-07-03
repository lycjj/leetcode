package com.ly.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ly.
 * @date 2021/6/30
 */
public class Question78 {
    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> listColl = new ArrayList<List<Integer>>();
        listColl.add(list);
        list = new ArrayList<Integer>();
        list.add(nums[0]);
        listColl.add(list);
        map.put(0, listColl);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(i - 1)) {
                listColl = new ArrayList<List<Integer>>();
                listColl.addAll(map.get(i - 1));
                for (List<Integer> subList : map.get(i - 1)) {
                    list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.addAll(subList);
                    listColl.add(list);
                }
            }
            map.put(i, listColl);
        }

        return map.get(nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);

    }
}
