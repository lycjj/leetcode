package com.ly.sortAlgorithm;

/**
 * 选择排序
 * @author ly.
 * @date 2021/2/10
 */
public class Selection {
    public static void sort(int[] a) {
        int min;
        int temp;
        for(int i = 0; i < a.length; i++) {
            min = i;
            for(int j = i+1; j < a.length; j++) {
                if(a[min] > a[j]) {
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {2,5,7,1,9};
        sort(a);
        System.out.println(a);
    }
}
