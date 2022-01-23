package com.wyq.elementary._02searchAndSort;

import com.wyq.util.Util;

/**
 * @program: algorithm-practice
 * @description: 冒泡排序  冒泡排序虽然简单，但确实是慢
 * @author: Mr.Wang
 * @create: 2021-04-28 21:38
 **/
public class _01BubbleSort {
    /*冒泡排序*/
    static void sort1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //如果前一项的值大于后一项，那么将前一项的值赋值个后一项。
                    Util.swap(arr, j, j + 1);
                }
                /*如果是前一项小于后一项的值，则不进行交换*/
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(30000, 0, 30000);
        long now =System.currentTimeMillis();
        sort1(arr);
        Util.duration(now);
        Util.print(arr);

    }
}
