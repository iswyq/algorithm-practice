package com.wyq.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序
 */
public class ShellSort {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] arr = new int[80000];
        /*
         * 添加随机数组 80000个数据
         * */
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        /*
         * 程序执行时间测试
         * */
        Date before = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String beforeTime = simpleDateFormat.format(before);
        //进行排序
        shellSort2(arr);
        Date after = new Date();
        String afterTime = simpleDateFormat.format(after);
        //打印程序执行时间
        System.out.println(beforeTime);
        System.out.println(afterTime);

//        System.out.println("排序结果");
//        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        int temp;//定义临时变量
        int count = 0;
        /*
         * 完整动作
         * 一层循环用于控制步长变化
         * 二层循环用于根据步长进行分组
         * 三层循环用于分组后 组内元素进行排序
         * */
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //每组中的元素是2个  他们之前的所有相差5
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        //每组中的前一个值大于后一个值  那么对他们进行交换
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }

//            System.out.printf("第%d排序后的结果\n", ++count);
//            System.out.println(Arrays.toString(arr));
        }


        /*
         *//*
         * 分解动作
         * *//*
        //第一轮 将10个数分成5组，每组两个数
        for (int i = 5; i < arr.length; i++) {
            //每组中的元素是2个  他们之前的所有相差5
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]) {
                    //每组中的前一个值大于后一个值  那么对他们进行交换
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }//测试通过

        //第二轮  将10个元素分成5/2 = 2组  每组5个元素
        for (int i = 2; i < arr.length; i++) {
            //每组中的元素是2个  他们之前的所有相差2
            for (int j = i -2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    //每组中的前一个值大于后一个值  那么对他们进行交换
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }//测试通过

        //第三轮 将10个元素分成 2/2 = 1组
        for (int i = 1; i < arr.length; i++) {
            //每组中的元素是2个  他们之前的所有相差1
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    //每组中的前一个值大于后一个值  那么对他们进行交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }*/
    }

    //对希尔排序进行优化  将交换式改为移动式
    private static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素开始，逐个对其所在的组进行插入排序
            for (int i = gap; i < arr.length; i++) {
                //使用j进行移动
                int j = i;
                int temp = arr[j];
                //这里if不能省  如果分组本来就是有序的，那么通过该if可以直接
                if (arr[j] < arr[j - gap]) {
                    //寻找到合适插入的位置
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while循环时候，就会找到合适的插入位置
                    arr[j] = temp;
                }
            }
        }
    }
}
