package com.ly.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 思路：动态规划dp[i] = dp[j]&&check(j,i)
 * @author ly.
 * @date 2021/7/25
 */
public class Question139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>();
        set.addAll(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length();i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];

    }



    public static void main(String[] args) {
        List<String> wordDicts = Arrays.asList(new String[]{"aaaa", "aa"});
        boolean result = new Question139().wordBreak("aaaaaaa", wordDicts);
        System.out.println(result);
    }
}
