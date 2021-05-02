package com.wyq.competition._10lanqiao;

import java.util.Scanner;

/**
 * @program: algorithm-practice
 * @description: 特别数的和
 * @author: Mr.Wang
 * @create: 2021-05-02 19:52
 **/
public class _06_F特别数的和 {
    /*
     * 在 1 到 40 中这样的数包括 1、2、9、10 至 32、39 和 40，共 28 个，他们的和是 574
     * 输入一个数n，从1开始找到n。这中间的数包含了数字1,2,9,0，问这些数加起来的值是多少
     * 思路：
     * 1.将数字转换为字符串，然后使用indexOf方法，判断里面是否包含了上述的四个数
     * 对于所有评测用例，1 ≤ n ≤ 10000。
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 这里进行初值的初始化的时候，由其需要注意的是不能赋值为0
        /*
        * 如果赋值为0的话，那么就一定会满足中间有一个数字为0这个条件，那么则要没有对这个位置上的值修改过的话，那么所有的数都会满足条件
        * 故可以选择赋值为一个其他的值
        * */
        int a=-1;
        int b=-1;
        int c =-1;
        int d=-1;
        long sum=0;
        for (int i = 1; i <= n; i++) {
            // 需要准备到10000
            // 分别提取出数字的个位，十位，百位，千位
             a = i % 10;
            if (i >= 10) {
                 b = i % 100 / 10;
            }
            if (i >= 100) {
                 c = i % 1000 / 100;
            }
            if (i >= 1000) {
                 d = i % 10000 / 1000;
            }
            if (a==2||a==0||a==1||a==9||b==2||b==0||b==1||b==9||c==2||c==0||c==1||c==9
            ||d==2||d==0||d==1||d==9
            ){
                sum+=i;
                // System.out.println(sum);
            }
        }
        System.out.println(sum);
    }
}
