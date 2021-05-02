package com.wyq.competition._11lanqiao;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: algorithm-practice
 * @description: 字符串分值和
 * @author: Mr.Wang
 * @create: 2021-05-01 15:40
 **/
public class _02_I字符串分值和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        char c[] = string.toCharArray();
        long ans = 0;
        for (int i = 0; i < c.length; i++) {
            HashSet<Character> set = new HashSet<Character>(); // HashSet去重
            //这里并没有去求字符串string的子集是什么。而且set集合只在内层for循环有效。
            //不明白为什么可以获得正确的答案，暂且先记住。
            for (int j = i; j < c.length; j++) {
                set.add(c[j]);
                ans += set.size();
            }
        }
        System.out.println(ans);
    }
}
