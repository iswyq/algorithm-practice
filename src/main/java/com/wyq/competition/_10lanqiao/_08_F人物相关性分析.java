package com.wyq.competition._10lanqiao;

import java.util.Scanner;

/**
 * @program: algorithm-practice
 * @description: 人物相关性分析
 * @author: Mr.Wang
 * @create: 2021-05-03 11:00
 **/
public class _08_F人物相关性分析 {
    /*
     * This is a story about Alice and Bob.Alice wants to send a private message to Bob.
     * 假设K=20，则Alice和Bob同时出现了2次，分别是“Alice and Bob”和“Bob. Alice”前者之间有5个字符，后者有2个字符
     * 样例输入：
     * 20
     * This is a story about Alice and Bob.Alice wants to send a private message to Bob.
     * 样例输出：
     * 2
     * 分析：
     * 1.使用String的split方法进行字符串的分隔
     * 2.但是找的话对于Bob.确定有困难
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        //不能连续进行两个输入
        scanner.nextLine();
        String s = scanner.nextLine();
        //以空格和.进行字符串的分隔
        String[] words = s.split("\\s|\\.");
        //记录每一个单词的长度
        int[] wordsLength = new int[words.length];

        int num = 0;
        for (int i = 0; i < words.length; i++) {
            wordsLength[i] = words[i].length();
        }
        //Alice------>Bob
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("Alice")) {
                int sum = 0;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[j].equals("Bob")) {
                        //将Alice与Bob之间所有的单词的长度都计算上
                        for (int k = i; k < j; k++) {
                            //每个单词的实际长度加上1
                            sum += wordsLength[k] + 1;
                        }
                        if (sum <= K) {
                            num++;
                        }
                    }
                }
            }
        }
        //Bob-------->Alice
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("Bob")) {
                int sum = 0;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[j].equals("Alice")) {
                        for (int k = i; k < j; k++) {
                            //每个单词的实际长度加上1
                            sum += wordsLength[k] + 1;
                        }
                        if (sum <= K) {
                            num++;
                        }
                    }
                }
            }
        }
        System.out.println(num);
    }
}
