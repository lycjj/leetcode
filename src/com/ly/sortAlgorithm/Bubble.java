package com.ly.sortAlgorithm;

/**
 * 把第一个元素和第二个元素作比较，如果第一个元素比第二个元素大，则交换它们的位置，接着再把第二个元素和第三个元素作比较，如果
 * 前一个元素比后一个人元素大，则交换它们的位置，这样一直下去，直至最后一个元素，这样一次排序以后，最后一个元素便是最大的数
 * 接着除去最后一个元素，再对剩余的元素进行上面同样的操作，如此重复下去，直至排序完成
 * 冒泡排序
 * @author ly.
 * @date 2021/2/10
 */
public class Bubble {
    public static void sort(int[] a) {
        int temp;
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length-1-i; j++) {
                if(a[j] > a[j+1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
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
