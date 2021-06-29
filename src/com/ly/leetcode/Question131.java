package com.ly.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ly.
 * @date 2021/2/11
 */
public class Question131 {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> ans = new ArrayList<String>();
        int n= s.length();
        boolean[][] f = new boolean[n][n];
        // 求出所有子串是否是回文子串
        for(int i = 0; i < n; i++) {
            Arrays.fill(f[i],true);
        }
        for(int i = n-1; i >=0; i--) {
            for(int j = i+1; j < n; j++) {
                f[i][j] = f[i+1][j-1] && s.charAt(i) == s.charAt(j);
            }
        }
        // 回溯法
        dfs(s,0,f,result,ans);
        return result;
    }

    public static void dfs(String s,int i,boolean[][] f,List<List<String>> result,List<String> ans) {
        if(i == s.length()) {
            result.add(new ArrayList<String>(ans));
            return;
        }
        for(int j = i; j < s.length(); j++) {
            if(f[i][j]) {
                ans.add(s.substring(i,j+1));
                dfs(s,j+1,f,result,ans);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> result =  partition("aab");
        System.out.println(result);
    }
}
