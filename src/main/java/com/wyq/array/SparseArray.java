package com.wyq.array;

/**
 * 稀疏数组与二维数组
 */
public class SparseArray {
    public static void main(String[] args) {
        /*
         * 创建原始二维数组
         * 1.创建一个11*11的二维数组
         * 0：无棋子  1：黑子  2：篮子
         *
         * */

        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][4] = 1;
        System.out.println("输出原始二维数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println("\n");
        }

        /*
         * 二维数组转稀疏数组
         * 1.先遍历二维数组中非0元素的个数sum
         * 2.根据sum创建出对应的稀疏数组,并将二维数组中的值填入
         *
         * */
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        int sparseArr[][] = new int[sum + 1][3];
//        稀疏数组第一行赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

//        打印稀疏数组
        System.out.println("打印稀疏数组~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        /*
         * 稀疏数组转二维数组
         * 1.创建二维数组
         * 2.遍历稀疏数组，将对应值填入到二维数组中
         * */
        System.out.println("输出二维数组~~");
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][0]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println("\n");
        }
        System.out.println();
    }
}
