package com.ly.leetcode;

/**
 * @author ly.
 * @date 2021/6/27
 */
public class Question38 {
    public static String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        String str,temp = "1";
        StringBuilder builder = new StringBuilder(temp);
        int index = 0, num = 0, targetIndex = 0;
        char[] array;
        for (int i = 1; i < n; i++) {
            builder = new StringBuilder();
            str = temp;
            array = str.toCharArray();
            // 之所以让index = 0,是为了str=1这种特殊的情况
            index = 0;
            num = 0;
            targetIndex = 0;
            while (index < str.length()) {
                if (array[index] == array[targetIndex]) {
                    num++;
                    if (index == str.length() - 1) {
                        builder.append(String.valueOf(num));
                        builder.append(String.valueOf(array[targetIndex]));
                        temp = builder.toString();
                    }
                    index++;
                } else {
                    builder.append(String.valueOf(num));
                    builder.append(String.valueOf(array[targetIndex]));
                    num = 0;
                    targetIndex = index;
                    temp = builder.toString();
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
