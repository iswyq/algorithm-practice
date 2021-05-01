package com.wyq.competition._11lanqiao;

import com.wyq.util.Util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: algorithm-practice
 * @description: 成绩分析
 * @author: Mr.Wang
 * @create: 2021-04-29 20:48
 **/
public class _05成绩分析 {
    /*
    * 输入从0到100的整数作为成绩，计算最高分，最低分，平均成绩
    * 样例输入：
    *   7
        80
        92
        56
        74
        88
        99
        10
    * 样例输出：
    *   99
        10
        71.29
    * */
    /*
    * 最值的获取使用排序
    *
    * */
    static void sort(int[]arr){
        Arrays.sort(arr);
        System.out.println(arr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //数组的长度
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i <N ; i++) {
            arr[i]=scanner.nextInt();
        }
        sort(arr);
        // Util.print(arr);
        float sum=0;
        for (int i = 0; i < N; i++) {
            sum+=arr[i];
        }
        System.out.println(arr[0]);
        System.out.println(arr[N-1]);
        //对float进行格式化输出
        DecimalFormat df = new DecimalFormat("#.00");
        String s = df.format(sum / N);
        System.out.println(s);
    //    字符串的规范打印String.format("%.2f")
    }
}
