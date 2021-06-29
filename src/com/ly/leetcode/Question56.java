package com.ly.leetcode;

import java.util.*;

/**
 * @author ly.
 * @date 2021/2/10
 */
public class Question56 {
    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> list = new ArrayList<int[]>();
        int[] temp;
        int[] tempTwo;
        for(int i = 0; i < intervals.length;i++) {
            temp = intervals[i];
            if(list.size() == 0) {
                list.add(temp);
            } else {
                tempTwo = list.get(list.size()-1);
                if(temp[0] <=tempTwo[1]) {
                    tempTwo[1] = Math.max(temp[1],tempTwo[1]);
                } else {
                    list.add(temp);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,9},{2,5},{19,20},{10,11},{12,20},{0,3},{0,1},{0,2}};
        int[][] result = merge(intervals);
        System.out.println(result);
    }
}
