package com.wyq.recursion;

/**
 * 走迷宫
 */
public class MiGong {
    public static void main(String[] args) {
        //1.创建地图
        int map[][] = new int[8][7];
        //2.上下置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[6][i] = 1;
        }
        //3.左右置为1
        for (int i = 0; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
//        map[3][1] = 1;
//        map[3][2] = 1;
        //输出地图情况
        System.out.println("输出地图的情况~");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        //走迷宫
        setWay(map, 1, 1);
        System.out.println("小球走过并进行标识");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 小球从(1,1)出发，
     * 1表示不可走，0表示可走 ，2表示通路可以走，3表示该路已经走过，但是走不通
     * 最后的重点是map(6,5)=2
     *
     * @param map 地图的情况
     * @param i
     * @param j
     */
    public static boolean setWay(int[][] map, int i, int j) {
        //按照下->右->上->左进行移动 如果该点走不通，则进行回溯
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {//表示当前点还没有走过
                //按照策略走
                map[i][j] = 2;
                //向下走
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    //向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    //向左走
                    return true;
                } else {
                    //说明这个点就走不通 值置为3
                    map[i][j] = 3;
                    return false;
                }
            } else { //map[i][j]的可能值为 1 2 3
                return false;
            }
        }
    }
}