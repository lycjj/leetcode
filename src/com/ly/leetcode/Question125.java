package com.ly.leetcode;

/**
 * @author ly.
 * @date 2021/5/16
 */
public class Question125 {
    public static boolean isPalindrome(String s) {
        if(s == null) {
            return false;
        }
        String lowCase = s.toLowerCase();
        int start = 0;
        int end = s.length()-1;
        char staChar,endChar;
        while (start < end) {
            staChar = lowCase.charAt(start);
            endChar = lowCase.charAt(end);
            if(!Character.isLetterOrDigit(staChar)) {
                start++;
            }else if(!Character.isLetterOrDigit(endChar)) {
                end--;
            } else if(staChar != endChar){
                return false;
            } else {
                start++;
                end--;
            }

        }
        return true;
    }

    public static void main(String[] args) {
       boolean result = isPalindrome("race a car");
        System.out.println(result);
    }
}
