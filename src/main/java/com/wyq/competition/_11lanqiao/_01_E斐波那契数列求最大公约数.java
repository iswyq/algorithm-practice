package com.wyq.competition._11lanqiao;

import java.math.BigInteger;

/**
 * @program: algorithm-practice
 * @description: 斐波那契数列求最大公约数
 * @author: Mr.Wang
 * @create: 2021-05-01 20:22
 **/
public class _01_E斐波那契数列求最大公约数 {
    /*
    * 总体的思路是使用BigInteger类型的数组进行计算。最重要的是获得斐波那契数列的第2020和520项的值，然后使用辗转相除法。
    * */
    public static void main(String[] args) {
        BigInteger arr[] = new BigInteger[2025]; // int long型数据均会爆数组
        arr[0] = BigInteger.ZERO;
        arr[1] = arr[2] = BigInteger.ONE;
        for (int i = 3; i <= 2020; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }
        for (int i = 1; i <= 7; i++) { // 输出斐波那契数组的元素值 验证
            System.out.println(i + ": " + arr[i]);
        }
        System.out.println(arr[520]);
        System.out.println(arr[2020]);
        System.out.println(arr[2020].mod(arr[520]));
        System.out.println(arr[2020].gcd(arr[520]));
    }
    public static BigInteger gcd(BigInteger a, BigInteger b) {
        return b.equals(BigInteger.ZERO) ? a : gcd(b, a.mod(b));
    }
}
