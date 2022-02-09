package com.wyq.recursion;

/**
 * 八皇后问题
 */
public class Queue8 {
    int max = 8;
    int arr[] = new int[8];//用以存放八个皇后的位置
    static int count = 0;//可行方案次数
    static int judgeCount = 0;//进行判断的次数

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d种方法", count);
        System.out.printf("一共判断了%d次",judgeCount);
    }
    /*
     * arr[8]={0,4,7,5,3,6,1,3}
     * 第一个皇后放置在1列
     * 第二个皇后放置在5列
     * 第三个皇后放置在8列
     * .....
     * */

    /**
     * @param n 表示当前要进行皇后欲放的位置
     * @return 返回放置该位置是否合理
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //arr[i]==arr[n] 表示他们在同一列
            //Math.abs(n-i)==Math.abs(arr[n]-i) 表示他们不在同一对角线上
            //对前面已经放置的每一个位置的皇后都需要进行比较
            //在对角线的位置上，水平的距离是一样滴   正方形知识
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void check(int n) {
        judgeCount++;
        //n=8时，表示达到了放置最后一个皇后的位置
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            //将第n个皇后放置在第一列(开始)
            arr[n] = i;
            //对前面的位置调用judge判断是否冲突
            if (judge(n)) {//表示放置合理
                //继续执行判断是否合理
                check(n + 1);
            }
            //当if中判断为false时，会继续执行for循环
        }
    }

    //打印皇后所在的位置
    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
}
