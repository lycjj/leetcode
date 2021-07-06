package com.ly.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ly.
 * @date 2021/7/6
 */
public class Question77 {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> subList = new ArrayList<Integer>();
        recursion(result,n,k,1,1,subList);
        return result;
    }

    private void recursion(List<List<Integer>> result,int n,int total,int k,int index,List<Integer> subList) {
        if(k > total) {
            List<Integer> sub = new ArrayList<Integer>();
            sub.addAll(subList);
            result.add(sub);
            return;
        }
        for(int i = index; i <= n; i++) {
            subList.add(i);
            recursion(result,n,total,k+1,i+1,subList);
            subList.remove(subList.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Question77().combine(4,2);
        System.out.println(result);
    }
}
