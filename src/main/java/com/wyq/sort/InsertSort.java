package com.wyq.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 5,9,10,23,15,68};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        int insertVal; //要进行插入的值
        int insertIndex;//欲插入的位置
        for (int i = 1; i < arr.length; i++) {
            insertIndex = i - 1; //至少需要往前走一个
            insertVal = arr[i];
            //找到合适的插入位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;//待插入的坐标值往前走
            }
            //经过while  待插入的位置已经找到  在其后的一个位置进行插入
            arr[insertIndex + 1] = insertVal;
        }
    }
}
