package com.wyq.competition._11lanqiao;

import java.util.Scanner;

/**
 * @program: algorithm-practice
 * @description: 寻找2020网友解答
 * @author: Mr.Wang
 * @create: 2021-04-29 15:52
 **/
public class _021寻找2020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] num = new int[301][301];
        for (int i = 1; i <= 300; i++) {
            String str = sc.next();
            for (int j = 1; j <= str.length(); j++) {
                num[i][j] = str.charAt(j - 1) - '0';
            }
        }
        int ans = 0;
        for (int i = 0; i <= 300; i++) {
            for (int j = 0; j <= 300; j++) {
                if (i + 3 <= 300 && num[i][j] == 2 && num[i + 1][j] == 0 && num[i + 2][j] == 2 && num[i + 3][j] == 0)
                    ans++;
            }
        }
        for (int i = 1; i <= 300; i++) {
            for (int j = 1; j <= 300; j++) {
                if (j + 3 <= 300 && num[i][j] == 2 && num[i][j + 1] == 0 && num[i][j + 2] == 2 && num[i][j + 3] == 0)
                    ans++;
            }
        }
        for (int i = 0; i <= 300; i++) {
            for (int j = 0; j <= 300; j++) {
                if (i + 3 <= 300 && j + 3 <= 300 && num[i][j] == 2 && num[i + 1][j + 1] == 0 && num[i + 2][j + 2] == 2
                        && num[i + 3][j + 3] == 0)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}
