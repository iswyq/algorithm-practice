package com.wyq.competition._10lanqiao;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: algorithm-practice
 * @description: 外卖店优先级
 * @author: Mr.Wang
 * @create: 2021-05-02 21:15
 **/
public class _07_G外卖店优先级 {
    /*
     * 第一行
     * 2 6 6  表示有2个外卖店，共计会有6条外卖信息，需要求解的是6时刻时候的结果
     * 5 1 表示5时刻时外卖点1号获得一个订单
     * 每获得一个订单，则加2个优先级，没有获得订单，则减少一个优先级。最低为0
     * 样例输入：
2 6 6
1 1
5 2
3 1
6 2
2 1
6 2
     * 样例输出
     * 1
     * */
    public static void main(String[] args) {
        /*设计思路：
         * 1.使用priority数组记录每一个商家当前的优先级是多少。使用该数组的下标可以确定是哪一个商家
         * 2.使用sign数组记录当前商家是否获得了订单。如果有则赋值为1，没有不进行赋值
         * 3.set集合用作优先缓存，记录进入到优先缓存中的商家。
         * 运行流程：
         * 1.对每一个时刻遍历order数组，确定在该时刻是否产生了订单。
         * 2.          遍历priority数组，确定是否有优先级小于3或者是大于3的情况。
         * 创新设计：
         * 1.没有专门存储商家的id，而是使用数组的下标来确定商家。减少复杂性。
         * 2.将复杂的工作进行了拆分。将订单及优先级的增删与是否进入缓存进行分开处理。
         * */
        Scanner scanner = new Scanner(System.in);
        //商家数量
        int N = scanner.nextInt();
        //订单数量
        int M = scanner.nextInt();
        //所求的时刻T
        int T = scanner.nextInt();
        //放置订单的数组
        int[][] order = new int[M][2];
        //标记时刻T是否获得了订单
        int[] sign = new int[N];
        //优先级数组
        int[] priority = new int[N];
        // 优先缓存
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            //时刻
            order[i][0] = scanner.nextInt();
            //商家
            order[i][1] = scanner.nextInt();
        }
        // 对每一个时刻为单位进行计算
        for (int i = 0; i < T; i++) {
            // i时刻是否有订单产生。因为数据输入时各个时刻分散开
            for (int j = 0; j < M; j++) {
                // 产生订单的时间是否与当前时间一样
                if (order[j][0] == i+1) {
                    priority[order[j][1] - 1] += 2;
                    //为获得订单的商家打上标记
                    sign[order[j][1] - 1] = 1;
                }
            }
            //遍历priority
            for (int j = 0; j < N; j++) {
                if (sign[j] == 0 && priority[j] > 0) {
                    //没有获得订单，优先级减少1
                    priority[j]--;
                }
                //continue会出现逻辑问题
                // else if (sign[j] == 1) {
                //     // 获得了订单，则不对优先级进行处理。
                //     continue;
                // }
                //优先级大于3并且不在优先缓存中
                if (priority[j] > 5 && !set.contains(j)) {
                    //加入
                    set.add(j);
                }
                if (priority[j] <= 3 && set.contains(j)) {
                    //移除
                    set.remove(j);
                }
            }
            //将标记位清零
            sign = new int[N];
        }
        //打印结果
        System.out.println(set.size());
    }
}
