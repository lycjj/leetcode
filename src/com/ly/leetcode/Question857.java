package com.ly.leetcode;

/**
 * @author ly.
 * @date 2021/6/15
 */
public class Question857 {
    public int peakIndexInMountainArray(int[] arr) {
        int length = arr.length;
        int left = 1,right = length-2,ans = 0,mid;
        while(left <= right) {
            mid = (left+right)/2;
            if(arr[mid] > arr[mid+1]) {
                right = mid-1;
                ans = mid;
            } else {
                left = mid+1;
            }
        }
        return ans;
    }
}