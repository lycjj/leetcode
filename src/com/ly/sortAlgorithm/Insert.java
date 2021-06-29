package com.ly.sortAlgorithm;

/**
 * 插入排序
 * 假设左边的数组是有序的，然后每次从剩余数据中将第一个拎出来，插入到左边有序数组的适当位置
 * @author ly.
 * @date 2021/2/10
 */
public class Insert {
    public static void sort(int[] a) {
        int temp;
        for(int i = 1; i < a.length; i++) {
            for(int j = i ; j > 0; j--) {
                if(a[j-1] > a[j]) {
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {2,5,7,1,9};
        sort(a);
        System.out.println(a);
    }
}
