package com.wyq.competition._11lanqiao;

import java.util.Scanner;

/**
 * @program: algorithm-practice
 * @description: 寻找2020
 * @author: Mr.Wang
 * @create: 2021-04-29 14:04
 **/
public class _02寻找2020 {
    private static int f(int[][] arr) {
        /*
         * 获得的一个二维数组，分别向左，向下，向右下找；使用三个循环。
         * */
        int ans = 0;
        //向右找
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 301; j++) {
                //注意索引越界
                if (j < 301 && j + 1 < 301 && j + 2 < 301 && j + 3 < 301 &&
                        //依次向后找2020，如果满足则加1
                        arr[i][j] == 2 && arr[i][j + 1] == 0 && arr[i][j + 2] == 2 && arr[i][j + 3] == 0) {
                    ans++;
                }
            }
        }
        //向下找
        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 300; j++) {
                if (j < 300 && j + 1 < 300 & j + 2 < 300 && j + 3 < 300 &&
                        arr[j][i] == 2 && arr[j + 1][i] == 0 && arr[j + 2][i] == 2 && arr[j + 3][i] == 00) {
                    ans++;
                }
            }
        }
        //向右下找
        
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[300][301];
        for (int i = 0; i < 300; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < 301; j++) {
                arr[i][j] = line.charAt(i * 301 + j) - '0';
            }
        }
        int ans = f(arr);
        System.out.println(ans);
    }
}
