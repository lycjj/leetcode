package com.ly.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ly.
 * @date 2021/6/22
 */
public class Question剑指Offer38 {
    public static String[] permutation(String s) {
        if(s == null || s.length() == 0) {
            return null;
        }
        char[] arr = s.toCharArray();
        Map<String,String> map = new HashMap<String,String>();
        backtract(0,arr,map);
        String[] result = new String[map.size()];
        int index = 0;
        for(String key : map.keySet()) {
            result[index++] = key;
        }
        return result;
    }

    public static void backtract(int pos, char[] s, Map<String,String> map) {
        if(pos == s.length) {
            String str = new String(s);
            map.put(str,str);
            return;
        }
        for(int i = pos; i < s.length; i++) {
            swap(s,pos,i);
            backtract(pos+1,s,map);
            swap(s,pos,i);
        }
    }

    public static void swap(char[] s, int i,int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        String[] result = permutation(str);
        System.out.println(result);
    }

}
