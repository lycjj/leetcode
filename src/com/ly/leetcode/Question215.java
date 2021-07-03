package com.ly.leetcode;

/**
 * 先用k个元素构造小根堆，然后遍历后面的元素,如果比堆顶元素大，则用该元素替代堆顶元素，然后内部维护小根堆
 * @author ly.
 * @date 2021/7/2
 */
public class Question215 {
    public int findKthLargest(int[] nums, int k) {
        int[] temp = new int[k + 1];
        for (int i = 0; i < k; i++) {
            temp[i + 1] = nums[i];
        }

        // 构造小顶堆
        for(int i = k/2; i > 0 ; i--) {
            sink(temp,i);
        }

        for(int i = k; i < nums.length; i++) {
            if(nums[i] > temp[1]) {
                temp[1] = nums[i];
                sink(temp,1);
            }
        }
        return temp[1];
    }

    // 堆排序中的下沉操作
    public void sink(int[] temp, int k) {
        int length = temp.length - 1;
        int index = k;
        while (2 * k <= length) {
            index = 2 * k;
            if (index < length && temp[index] > temp[index + 1]) {
                index++;
            }
            if(temp[k] <= temp[index]) {
                break;
            }
            if (temp[k] > temp[index]) {
                swap(temp, k, index);
            }

            k = index;
        }
    }

    public void swap(int[] temp, int i, int j) {
        int te = temp[i];
        temp[i] = temp[j];
        temp[j] = te;
    }

    public static void main(String[] args) {
        int[] array = {3,2,1,5,6,4};
        System.out.println(new Question215().findKthLargest(array,2));
    }
}
