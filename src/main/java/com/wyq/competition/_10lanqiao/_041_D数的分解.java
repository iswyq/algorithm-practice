package com.wyq.competition._10lanqiao;

/**
 * @program: algorithm-practice
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-02 17:31
 **/
public class _041_D数的分解 {
    public static void main(String[] args) {
        int n = 2019;
        int num = 0;
        for (int i = 1; i < n; i++) {
            if (String.valueOf(i).indexOf("2") != -1 || String.valueOf(i).indexOf("4") != -1)
                continue;
            for (int j = i + 1; j < n; j++) {
                if (String.valueOf(j).indexOf("2") != -1 || String.valueOf(j).indexOf("4") != -1)
                    continue;
                int k = n - i - j;
                if (i == k || j == k || i == j)
                    continue;
                if (k > 0 && String.valueOf(k).indexOf("2") == -1 && String.valueOf(k).indexOf("4") == -1) {
                    num++;
                }
            }
        }
        System.out.println(num / 3);
    }

}
