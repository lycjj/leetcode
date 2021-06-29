package com.ly.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ly.
 * @date 2021/6/21
 */
public class Question401 {
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 60; j++) {
                if(Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    ans.add(i+":"+(j < 10 ? "0"+j:j));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
    }
}
