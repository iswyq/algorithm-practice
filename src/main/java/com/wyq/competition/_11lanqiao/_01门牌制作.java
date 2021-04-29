package com.wyq.competition._11lanqiao;

/**
 * @program: algorithm-practice
 * @description: 门牌制作
 * @author: Mr.Wang
 * @create: 2021-04-29 13:41
 **/
public class _01门牌制作 {
    /*
    * 小蓝制作门牌的方法是先制作0 到9 这几个数字字符，最后根据需要将字
      符粘贴到门牌上，例如门牌1017 需要依次粘贴字符1、0、1、7，即需要1 个
      字符0，2 个字符1，1 个字符7。
      请问要制作所有的1 到2020 号门牌，总共需要多少个字符2？
    * */
    //题目的意思：从1-2020，统计有多少个2
    static void f() {
        int count = 0;
        for (int i = 0; i <= 100; i++) {
            //提取个位
            if (i % 10 == 2) {
                count++;
            }
            //提取十位
            if ((i / 10) % 10 == 2) {
                count++;
            }
            //提取百位
            if ((i / 100) % 10 == 2) {
                count++;
            }
            if ((i / 1000) % 10 == 2) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        f();
    }

}
