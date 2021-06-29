package com.ly.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 大根堆就是父节点大于等于子节点的完全二叉树
 * 思路：先用大根堆(堆顶为最大值的堆)维护前n个数，再遍历数组中其余数，如果该数比堆顶的数小，则入堆
 */

/**
 * @author ly.
 * @date 2021/5/30
 */
public class Question剑指Offer40 {
    public  static int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        if(k > arr.length || k < 1) {
            return result;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        for(int j = k; j < arr.length;j++) {
            if(queue.peek() > arr[j]) {
                queue.poll();
                queue.offer(arr[j]);
            }
        }
        for(int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.println(getLeastNumbers(arr,4));
    }
}
