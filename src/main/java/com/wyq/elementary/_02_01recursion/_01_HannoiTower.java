package com.wyq.elementary._02_01recursion;

/**
 * @program: algorithm-practice
 * @description: 汉诺塔
 * @author: Mr.Wang
 * @create: 2021-04-28 20:08
 **/
public class _01_HannoiTower {
    /*
    * 汉诺塔的游戏递归分解步骤：
    * 1.将上面的N-1个盘子从A柱子移动到C柱子，这时B柱子是辅助
    * 2.将第N个盘子从A柱子移动到B柱子
    * 3.将N-1个盘子从C柱子移动到B柱子，这时A柱子是辅助
    * 在不同的递归过程中，源、目的地、辅助在不听的更换
    * */
    /**
     * 打印汉诺塔的操作步骤
     *
     * @param N    盘子数量
     * @param from 源
     * @param to   目的
     * @param help 辅助柱子
     */
    static void printHannoiTower(int N, String from, String to, String help) {
        if (N==1){
            System.out.println("move " + N + " from " + from + " to " + to);
            return;
        }
        // 源是from，目的是to，help是to
        printHannoiTower(N - 1, from,help,to);
        System.out.println("move " + N + " from " + from + " to " + to);
        //将剩下的N-1个盘子从c柱移动到b柱，以a柱为辅助
        printHannoiTower(N - 1, help,to,from);
    }

    public static void main(String[] args) {
        printHannoiTower(3, "a", "b", "c");
    }
}
