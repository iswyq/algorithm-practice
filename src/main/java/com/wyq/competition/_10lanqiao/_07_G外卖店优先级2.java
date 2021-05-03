package com.wyq.competition._10lanqiao;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @program: algorithm-practice
 * @description: 外卖店优先级的其他解法
 * @author: Mr.Wang
 * @create: 2021-05-03 10:05
 **/
public class _07_G外卖店优先级2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            Set<Integer> set = new HashSet<Integer>();
            int N = input.nextInt(); // N 家外卖店，编�?? 1 �?? N
            int M = input.nextInt(); // 给定 T 时刻以内�?? M 条订单信�??
            int T = input.nextInt();
            int[][] orders = new int[M][2]; // 给定 T 时刻以内�?? M 条订单信�??
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < 2; j++) {
                    orders[i][j] = input.nextInt();
                }
            }

            int[] priority = new int[N];
            int[] sign = new int[N];
            for (int i = 1; i <= T; i++) {
                for (int j = 0; j < M; j++) {
                    if (orders[j][0] == i) {
                        priority[orders[j][1] - 1] += 2;
                        if (priority[orders[j][1] - 1] > 5 && !set.contains(orders[j][1] - 1)) {
                            set.add(orders[j][1] - 1);
                        }
                        sign[orders[j][1] - 1] = 1;
                    }
                }
                for (int j = 0; j < N; j++) {
                    if (sign[j] == 0 && priority[j] > 0)
                        priority[j]--;
                    if (priority[j] <= 3) {
                        set.remove(j);
                    }
                }
                sign = new int[N];
            }
            System.out.println(set.size());
        } catch (Exception e) {
            input.close();
        }
    }

}
