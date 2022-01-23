package com.wyq.elementary._01xor;

import java.util.Scanner;

/**
 * @program: algorithm-practice
 * @description: 对输入的一个数转换为二进制数，并输出二进制中的数有多少个1
 * @author: Mr.Wang
 * @create: 2021-04-28 16:17
 **/
public class _03_1的个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        //直接以二进制的形式输出该数
        System.out.println(Integer.toString(N, 2));
        //比对每一位
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((N & (1 << i)) == (1 << i)) {
            //    按位进行与操作就是将当前位置的数保留，其余位置的数置0
                count++;
            }
        }
        System.out.println(count);
    }
}
