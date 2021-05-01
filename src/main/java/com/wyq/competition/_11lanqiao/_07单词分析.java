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
    * 之前是自己进行代码逻辑的构建，但是存在很多问题。比如不能进行出现次数相同的统计
    * 故从别人的代码中进行借鉴
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char charArray[] = sc.next().toCharArray(); // 字符数组
        int nums[] = new int[26]; // int型数组 记录 每个字母的出现次数
        for (int i = 0; i < charArray.length; i++) {
            //这里的代码有点神奇，可以将对应字典序的出现的次数放在对应的位置中
            //即a出现了3次，那么nums[0]的值为3
            nums[charArray[i] - 'a']+=1;
        //    整个代码很巧妙的就在这里。
        }
        int ans = nums[0], index = 0;
        for (int i = 0; i < 26; i++) {
            if (nums[i] > ans) {
                ans = nums[i];
                index = i;
            }
        }
        System.out.println((char) ('a' + index) + "\n" + ans);
    }
}
