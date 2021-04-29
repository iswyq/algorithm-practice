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
        /*
        * 16520这个答案可能不是正确的，因为在自己写的代码中，将最后的一个for循环的301改为300后就可以得到16520的答案。
        * 16520的答案看看就好。
        * */
        int ans = 0;
        //向右找
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 301; j++) {
                //注意索引越界
                if (j + 3 < 301 &&
                        //依次向后找2020，如果满足则加1
                        arr[i][j] == 2 && arr[i][j + 1] == 0 && arr[i][j + 2] == 2 && arr[i][j + 3] == 0) {
                    ans++;
                }
            }
        }
        //向下找
        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 300; j++) {
                if (j + 3 < 300 &&
                        arr[j][i] == 2 && arr[j + 1][i] == 0 && arr[j + 2][i] == 2 && arr[j + 3][i] == 0) {
                    ans++;
                }
            }
        }
        //向右下找
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 300; j++) {
                if (i + 3 < 300 && j + 3 < 301 &&
                        arr[i][j] == 2 && arr[i + 1][j + 1] == 0 && arr[i + 2][j + 2] == 2 &&
                        arr[i + 3][j + 3] == 0
                ) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[301][301];
        for (int i = 0; i < 300; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        int ans = f(arr);
        System.out.println(ans);
    }
}
