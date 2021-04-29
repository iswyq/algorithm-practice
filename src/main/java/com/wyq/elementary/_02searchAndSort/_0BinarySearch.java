package com.wyq.elementary._02searchAndSort;

import com.wyq.util.Util;

/**
 * @program: algorithm-practice
 * @description: 二分查找
 * @author: Mr.Wang
 * @create: 2021-04-28 20:53
 **/
public class _0BinarySearch {
    /**
     * 二分查找的递归解法 返回key在数组中的索引号
     *
     * @param arr
     * @param low
     * @param high
     * @param key
     * @return
     */
    private static int binarySearch0(int[] arr, int low, int high, int key) {
        //没有找到
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        int midVal = arr[mid];
        if (key > midVal) {
            //    要找的值在右侧
            low = mid + 1;
            //相信二分查找能够从下一次的查找中找到
            return binarySearch0(arr, low, high, key);
        } else if (key < midVal) {
            high = mid - 1;
            return binarySearch0(arr, low, high, key);
        } else {
            //    key就是中值
            return mid;
        }
    }

    /**
     * 二分查找的循环解法
     *
     * @param arr
     * @param low
     * @param high
     * @param key
     * @return
     */
    private static int binarySearch1(int[] arr, int low, int high, int key) {
        int mid = low + (high - low) / 2;
        int midVal = arr[mid];
        //结束条件是当low大于high的时候
        while (low <=high) {
            mid = low + (high - low) / 2;
            midVal = arr[mid];
            if (key < midVal) {
                //    说明在左侧
                high = mid - 1;
            } else if (key > midVal) {
                //    说明在右侧
                low = mid + 1;
            } else {
                // 在此处返回后直接结束了程序
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] x = new int[10000 * 10000];
        for (int i = 0; i < x.length; i++) {
            x[i] = i + 1;
        }
        int target = 100000 * 1000;
        long now = System.currentTimeMillis();
        int index = binarySearch0(x, 0, x.length - 1, target);
        Util.duration(now);
        System.out.println(target + " 所在位置为 " + index);
        now = System.currentTimeMillis();
        index = binarySearch1(x, 0, x.length - 1, target);
        Util.duration(now);
        System.out.println(target + " 所在位置为 " + index);

    }
}
