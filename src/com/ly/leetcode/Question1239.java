package com.ly.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ly.
 * @date 2021/6/20
 */
public class Question1239 {
    private static int ans = 0;

    public static int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<Integer>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch; // 将 ch 加入 mask 中
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }

        backtrack(masks, 0, 0);
        return ans;
    }

    public static void backtrack(List<Integer> masks, int pos, int mask) {
         if (pos == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        if ((mask & masks.get(pos)) == 0) { // mask 和 masks[pos] 无公共元素
            backtrack(masks, pos + 1, mask | masks.get(pos));
        }
        backtrack(masks, pos + 1, mask);
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<String>();
        arr.add("cha");
        arr.add("r");
        arr.add("act");
        arr.add("ers");
        maxLength(arr);
    }
}
