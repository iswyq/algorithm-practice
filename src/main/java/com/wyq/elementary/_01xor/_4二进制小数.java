package com.wyq.elementary._01xor;

/**
 * @program: algorithm-practice
 * @description: 将一个十进制的小数转换为一个二进制的数
 * @author: Mr.Wang
 * @create: 2021-04-28 16:30
 **/
public class _4二进制小数 {
    public static void main(String[] args) {
        /*将小数转换为二进制小数的方法：
         * 1.一直进行乘以2的操作，如果结果大于2则减去1，二进制数在该位为1
         * 2.直到进行乘以2后结果为1，则表示结果已经完成了转换
         *
         * */
        double num = 0.625;
        StringBuffer sb = new StringBuffer("0.");
        while (num > 0) {
            double r = num * 2;
            if (r >= 1) {
                num = r - 1;
                //消除掉整数部分
                sb.append("1");
            } else {
                // 表示已经上一步的r正好为1，num为0
                num = r;
                sb.append("0");
            }
        }
        System.out.println(sb.toString());
    }
}
