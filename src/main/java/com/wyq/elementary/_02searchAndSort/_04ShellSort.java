package com.wyq.elementary._02searchAndSort;

import com.wyq.util.Util;

/**
 * @program: algorithm-practice
 * @description: 希尔排序
 * @author: Mr.Wang
 * @create: 2021-04-29 12:18
 **/
public class _04ShellSort {
    /*
    * 希尔排序，增量缩小排序。实现原理同插入排序
    * 增量的间隔是一个规律变化的量（以length每一次递减1/2），插入排序增量为1
    * */
    private static void sort(int[] arr) {
        for (int interval = arr.length / 2; interval > 0; interval = interval / 2) {

            for (int i = interval; i < arr.length; i++) {
                int target = arr[i];
                int pre = i - interval;
                while (pre > -1 && arr[pre] > target) {
                    //    前一个的值大于后一个，向后移动
                    arr[pre+1]=arr[pre];
                    //pre以interval的间隔减少
                    pre=pre-interval;
                }
                arr[pre+interval]=target;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(5, 0, 10);
        sort(arr);
        Util.print(arr);
    }
}
