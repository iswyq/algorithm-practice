package com.wyq.array;

import java.io.*;

/**
 * 对稀疏数组的值保存到文件中
 */
public class SparseArrayEx {
    public static void main(String[] args) throws IOException {
//        arrayRead();
        SparseArrayEx1 ex1 = new SparseArrayEx1();
        int chessArr1[][] = new int[4][3];
        chessArr1[0][0] = 11;
        chessArr1[0][1] = 11;
        chessArr1[0][2] = 3;
        chessArr1[1][0] = 1;
        chessArr1[1][1] = 2;
        chessArr1[1][2] = 1;
        chessArr1[2][0] = 2;
        chessArr1[2][1] = 3;
        chessArr1[2][2] = 2;
        chessArr1[3][0] = 3;
        chessArr1[3][1] = 4;
        chessArr1[3][2] = 1;
//        chessArr1[]
//        ex1.arrayWrite(chessArr1);
        ex1.arrayRead();
    }
}

class SparseArrayEx1 {
    public SparseArrayEx1() {

    }

    //将稀疏数组还原成二维数组
    public void arrayRead() throws IOException {
        File file = new File(".\\array.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file.getCanonicalPath()));
        String s1 = reader.readLine();
        String[] split = s1.split(",");
        //二维数组
        int chessarr[][] = new int[Integer.parseInt(split[0])][Integer.parseInt(split[1])];
        //待恢复的稀疏数组
        int sparsearr[][] = new int[Integer.parseInt(split[2])+1][3];
        int sum = -1;
        //恢复为稀疏数组
        for (int i = 0; i < split.length; i+=3) {
            //索引越界异常
            sum++;
            sparsearr[sum][0] = Integer.parseInt(split[i]);
            sparsearr[sum][1] = Integer.parseInt(split[i + 1]);
            sparsearr[sum][2] = Integer.parseInt(split[i + 2]);
        }
        //打印稀疏数组
        System.out.println("打印稀疏数组~~~");
        for (int i = 0; i < sparsearr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparsearr[i][0], sparsearr[i][1], sparsearr[i][2]);
        }
        //稀疏数组转换为二维数组
    }

    protected void arrayWrite(int[][] arr) throws IOException {
        File file = new File(".\\array.txt");
//        返回一个规范路径
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getCanonicalPath(), true));
        for (int i = 0; i < arr.length; i++) {
            writer.write(arr[i][0] + "," + arr[i][1] + "," + arr[i][2] + ",");
        }
        writer.close();

    }
}
