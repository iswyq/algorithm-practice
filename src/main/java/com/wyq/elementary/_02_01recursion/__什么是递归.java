package com.wyq.elementary._02_01recursion;

import com.wyq.util.Util;

/**
 * @program: algorithm-practice
 * @description: 递归的理解及基本使用
 * @author: Mr.Wang
 * @create: 2021-04-28 16:46
 **/
public class __什么是递归 {
    /*
     * 插入排序
     * 将前k-1个元素通过方法排好序，将第k个元素插入到这个序列中
     * */
    static void insertSort(int[] arr, int k) {
        //边界条件
        if (k == 0) {
            return;
        }
        //前k-1个元素已经排好序
        insertSort(arr, k - 1);
        //将第k个元素添加到这个数组中
        int index = k - 1; //其实就是最后一个
        int x = arr[k];
        while (index > -1 && x < arr[index]) {
            arr[index + 1] = arr[index];
            index--;
        }
        arr[index + 1] = x;
    }
    /*
     * 求两个数的最大公约数
     * 使用辗转相除法 18 12 的最大公约数 为6
     * */

    /**
     * 找两个数的最大公约数
     *
     * @param n 数1
     * @param m 数2
     * @return
     */
    static int gcd(int n, int m) {
        // 如果两数相除的结果余数为0，在当前层的除数为最大公约数
        if (m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }
    /*
     * 求斐波拉契数列的某一项
     * */

    /**
     * 1 1 2 3 5 8
     *
     * @param n 表示要求的项，比如说第5项
     * @param m 一个辅助的位。当前的项
     * @return
     */
    static int fib(int n, int m) {
        // 当为1或者是为2的时候都直接返回为1
        if (m == 1) {
            return 1;
        }
        if (m == 2) {
            return 1;
        }
        return fib(n, m - 1) + fib(n, m - 2);
    }
    /*
     * 翻转字符串
     * */

    /**
     * @param src
     * @param end 用于指示字符串最后的一个长度
     * @return
     */
    static String reverse(String src, int end) {
        if (end == 0) {
            return "" + src.charAt(end);
        }
        return src.charAt(end) + reverse(src, end - 1);
    }

    /*
     * 对所有的元素进行求和
     * 变化：指向数组的指针
     * 重复：加
     * 边界：数组的长度-1
     * */
    static int f3(int[] arr, int i) {
        //对最后的一个元素直接进行返回
        if (i == arr.length - 1) {
            return arr[i];
        }
        return arr[i] + f3(arr, i + 1);
    }

    /*
     * 打印变量i到变量j之间的数
     * 变化：一个指向的量n在不断地向j靠近
     * 重复：n+f(n+1)
     * 边界：n=j
     * */
    static void f2(int i, int j) {
        if (i == j) {
            System.out.println(j);
            //结束条件用return 当使用return以后，递归层层返回
            return;
        }
        System.out.println(i);
        f2(i + 1, j);
    }

    /*
     * 求n的阶乘n!,使用递归进行实现
     * 重复：n*f(n-1)
     * 变化：n
     * 边界：n-1=1
     * */
    static int f1(int n) {
        // 边界条件
        if (n == 1) {
            return 1;
        }
        return n * f1(n - 1);
    }

    public static void main(String[] args) {
        // int i = f1(5);
        // System.out.println(i);
        // f2(2, 9);
        // int i3 = f3(new int[]{1, 2, 3, 4, 5}, 0);
        // System.out.println(i3);
        // System.out.println(reverse("abcd", 3));
        // System.out.println(fib(6, 6));
        // System.out.println(gcd(12, 14));
        int[] arr = {2,3,1,8,5,6,4};
        insertSort(arr,arr.length-1);
        Util.print(arr);
    }
}
