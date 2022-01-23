package com.wyq.competition._10lanqiao;

/**
 * @program: algorithm-practice
 * @description: 数的分解
 * @author: Mr.Wang
 * @create: 2021-05-02 15:26
 **/
public class _04_D数的分解 {
    /*
     * 把 2019 分解成 3 个各不相同的正整数之和，
     * 并且要求每个正整数都不包含数字 2 和 4，一共有多少种不同的分解方法？
     * 1000+1001+18 和 1001+1000+18 被视为同一种
     * 思路：
     * 1.使用三层循环去跑，将三个合适的数加入到set集合中
     * 2.set集合的size/3。（不对。1002+999+18也是可以的）
     *
     * 优化思路：
     * 1.三层循环去跑，将满足要求的结果进行计数cnt
     * 2.A+B+C可以对应有6中不同的顺序组合，那么在最后的时候将cnt/6即可
     * 这个算法不可以，因为时间上花费太多了。
     *
     * 要求为正整数，故不能从0开始。前面的两个continue的逻辑条件应该是或的关系，只要是当前的数中有一个2或者是4,jq
     * 就可以不用进入到循环中，减少循环次数。
     * */
    public static void main(String[] args) {
        int ans = 0;
        for (int i = 1; i < 2019; i++) {
            int i1 = String.valueOf(i).indexOf("2");
            int i2 = String.valueOf(i).indexOf("4");
            if (i1 != -1 || i2 != -1)
                continue;
            for (int j = 1; j < 2019; j++) {
                int j1 = String.valueOf(j).indexOf("2");
                int j2 = String.valueOf(j).indexOf("4");
                if (j1 != -1 || j2 != -1) continue;
                int k = 2019 - i - j;
                if (i == j || j == k || i == k) continue;
                int k1 = String.valueOf(k).indexOf("2");
                int k2 = String.valueOf(k).indexOf("4");
                if (k > 0 && k2 == -1 && k1 == -1) {
                    ans++;
                }
            }
        }
        System.out.println(ans / 6);
    }
}
