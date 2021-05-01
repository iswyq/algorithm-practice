package com.wyq.competition._11lanqiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: algorithm-practice
 * @description: 单词分析
 * @author: Mr.Wang
 * @create: 2021-04-29 21:11
 **/
public class _07单词分析 {
    /*
    * 输入一行包含一个单词，单词只由小写英文字母组成。
    *
    * 输出两行，第一行包含一个英文字母，表示单词中出现得最多的字母是哪
      个。如果有多个字母出现的次数相等，输出字典序最小的那个。
      第二行包含一个整数，表示出现得最多的那个字母在单词中出现的次数。
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[i] = c;
        }
        f(arr);
    }

    /**
     * @param arr
     */
    private static void f(char[] arr) {
        /*
         * 1.将字符串进行排序
         * 2.
         * */
        Arrays.sort(arr);
        //记录有哪些重复的字符
        char[] charStr = new char[arr.length];
        //记录字符的出现次数，与charStr的下标保持一致
        int[] numArr = new int[arr.length];
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            //    因为已经排序，所以相同的元素会在一起
            int n=i;
            while (arr[n] == arr[n + 1]) {
                //记录次数
                num++;
                n++;
            }
            //将对应的字符放置在数组中
            charStr[i]=arr[n];
            //放置字符对应的出现次数
            numArr[i]=num;
        }
        //调用打印方法，将结果按照题目要求进行输出
        print(charStr,numArr);
    }

    /**
     *
     * @param charStr
     * @param numArr
     */
    private static void print(char[] charStr, int[] numArr) {
        //记录最大出现次数
        int max=0;
        //记录下标
        int n=0;
        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i]>numArr[i+1]){
                max=numArr[i];
                n=i;
            }else{
                max=numArr[i+1];
                n=i;
            }
        }
        System.out.println(charStr[n]);
        System.out.println(max);
    }
}
