package com.wyq.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序
 */
public class BubbleSort {

    //第一次排序，最大的数放置在最后
    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 20, 10};
        bubbleSortTest();

    }

    public static void bubbleSortTest() {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        //测试运行时间
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间" + format1);
        bubbleSort(arr);
        Date date2 = new Date();
        String format2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间" + format2);
//        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;//临时变量
        boolean flag = false;//表示一次比较过程是否发生了交换
        //外层循环控制逐渐减少的次数
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环控制自前向后的比较
            for (int j = 0; j < arr.length - i - 1; j++) {
                //temp保存前一个变量
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j + 1];
                    //交换
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
//            System.out.printf("第%d排序结果", i + 1);
//            System.out.println(Arrays.toString(arr));

            //代码优化
            if (!flag) {//没有发生交换
                break;
            } else {
                flag = false;//标识变量进行重置
            }
        }
    }
}
