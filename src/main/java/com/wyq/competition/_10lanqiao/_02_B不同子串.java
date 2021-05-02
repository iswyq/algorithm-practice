package com.wyq.competition._10lanqiao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: algorithm-practice
 * @description: 不同子串
 * @author: Mr.Wang
 * @create: 2021-05-02 14:43
 **/
public class _02_B不同子串 {
    /*
     * 字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共 7 个
     * 字符串0100110001010001 有多少个不同的非空子串
     * 思路：
     * 1.长度为1的字符串有哪些，为2的字符串有哪些，为3的有哪些……
     * 2.将截取出来的子串放置到Set集合中。
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashSet<String> set = new HashSet<>();
        //长度的变化
        for (int i = 1; i <= s.length(); i++) {
            //开始截取的位置变化
            for (int j = 0; j < s.length(); j++) {
                //
                if (j + i <=s.length()) {
                    String substring = s.substring(j, j + i);
                    set.add(substring);
                }else {
                    String substring = s.substring(j);
                    set.add(substring);
                }
            }
        }
        System.out.println(set.size());
        // () -> System.out.println("hello world");
        System.out.println(set.toString());
    }
}
