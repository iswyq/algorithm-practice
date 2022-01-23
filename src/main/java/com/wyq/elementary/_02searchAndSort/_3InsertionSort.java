package com.wyq.elementary._02searchAndSort;

import com.wyq.util.Util;

/**
 * 它的基本思想是将一个记录插入到已经排好序的有序表中，从而一个新的、记录数增1的有序表。</br>
 * 在其实现过程使用双层循环，外层循环对除了第一个元素之外的所有元素，内层循环对当前元素前面有序表进行待插入位置查找，并进行移动
 *
 * @program: algorithm-practice
 * @description: 插入排序
 * @author: Mr.Wang
 * @create: 2021-04-28 22:47
 **/
public class _3InsertionSort {
    /*
     * 插入排序的过程如下：
     * 使用key保留着后一个元素
     * 3,2,1  key=2
     * 3,3,1 由于前一个元素的值大于后一个元素值，故大值向后移动
     * 2,3,1 将key赋值给arr[0]
     * 2,3,3 key=1 由于3>1，故3向后移动
     * 2,2,3 将2与key进行比较，2>key，故2向后移动
     * 1,2,3 将key赋值给arr[0]
     * */

    /**
     * 插入排序，将最大值放置在数组最末尾
     *
     * @param arr
     * @param low
     * @param high
     */
    private static void sort(int[] arr, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            // key和pre就分别指向了一前一后的元素
            int key = arr[i];
            int pre = i - 1;
            //注意：这里是与key进行比较，而不是只与前一个元素进行比较
            while (pre >= low && arr[pre] > key) {
                //将大的元素向后移动
                arr[pre + 1] = arr[pre];
                pre--;
            }
            //将key赋值到arr[0]
            arr[pre + 1] = key;
        }
    }

    /**
     * 对插入排序进行反向
     * @param arr
     * @param low
     * @param high
     */
    private static void sort1(int[] arr, int low, int high) {

    }

    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(5, 0, 10);
        sort(arr, 0, arr.length);
        Util.print(arr);
    }
}
