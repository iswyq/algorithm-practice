package com.wyq.elementary._02searchAndSort;

import com.wyq.util.Util;

/**
 * 第一次从待排序的数据元素中选出最小（或最大）的一个元素，</br>
 * 存放在序列的起始位置，然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾。</br>
 * 以此类推，直到全部待排序的数据元素的个数为零。</br>
 * 选择排序是一种不稳定的排序</br>
 * @program: algorithm-practice
 * @description: 选择排序
 * @author: Mr.Wang
 * @create: 2021-04-28 22:29
 **/
public class _2SelectionSort {
    /*选择排序和冒泡排序有很多相似的地方。*/
    /*循环的第一遍首先获得的就是整个数组中最小的值，第二遍就是整个数组中第二小的值，以此类推。*/
    private static void sort(int[] arr, int low, int high) {
        for (int i = 0; i < arr.length; i++) {
            //因为min的值会发生覆盖，所以单独提取出来
            //因为min和i发生了交换，所以min始终就是i的序列增加值
            int min = i;
            for (int j = min + 1; j < high; j++) {
                if (arr[min]>arr[j]){
                    //这里的覆盖是区别于插入排序的值的覆盖的，因为这里进行的是最小值索引的覆盖，而不是真正的数组中的值进行覆盖。
                    //将min换作为最小的值  覆盖
                    min = j;
                }
            }
            //将最小值与当前的位置的值进行交换
            //如果没有发生覆盖，则就是自己与自己进行交换，
            //如果在上面的代码中进行了交换，就是将i换作min
            Util.swap(arr, min,i);
        }
    }

    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(10, 5, 100);
        sort(arr, 0, arr.length);
        Util.print(arr);
    }
}
