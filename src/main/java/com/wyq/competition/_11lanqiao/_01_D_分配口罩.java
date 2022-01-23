package com.wyq.competition._11lanqiao;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.wyq.util.Util;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: algorithm-practice
 * @description: 省赛第一场D分配口罩
 * @author: Mr.Wang
 * @create: 2021-05-01 19:30
 **/
public class _01_D_分配口罩 {
    public static void main(String[] args) {
        int[] arr = new int[15];
        Scanner scanner = new Scanner(System.in);
        long sum=0;
        for (int i = 0; i < 15; i++) {
            arr[i] = scanner.nextInt();

        }
        for (int i = 8; i < 15; i++) {
            sum+=arr[i];
        }
        Arrays.sort(arr);
        Util.print(arr);
        System.out.println(sum/7);
    }
}
