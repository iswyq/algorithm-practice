package com.wyq.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {3, 2, 5, 1};
        selectSort(arr);
    }

    public static void selectSort(int[] arr) {
        int min;//假定最小的值
        int minIndex; //定义最小值所在索引  用于数组互换值
        //外层循环控制轮次
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            minIndex = i;
            //内存循环用于找到最小的值
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    //使得min又成为最小的值
                    min = arr[j];
                    minIndex = j;//对最小值的索引进行重新赋值
                }
            }
            //min就是最小的值，其所在位置为minIndex
            //因为最小值所在的值以及都已经保存  可以对其进行覆盖 不会导致数组内容丢失
            arr[minIndex] = arr[i];
            arr[i] = min;
            System.out.printf("第%d排序\n", i);
            System.out.println(Arrays.toString(arr));
        }
    }

}
