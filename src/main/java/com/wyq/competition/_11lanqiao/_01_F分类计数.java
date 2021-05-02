package com.wyq.competition._11lanqiao;

import java.util.Scanner;

/**
 * @program: algorithm-practice
 * @description: 分类计数
 * @author: Mr.Wang
 * @create: 2021-05-01 20:59
 **/
public class _01_F分类计数 {
    /*
     * 在该问题中，对于字典序的理解出错。字典序应该是从左往右每一个字母都尽量地靠近Z，
     * 而不是通过一定的划分使得整个字符串的最大。举个例子：
     * 123242526  就应该划分为12 3 24 25 26这样对应的字符串是LCXYZ；而不能划分为1 23 24 25 26；其对应的字符串是AWXYZ
     * 个人思路：
     * 1.大于3不能作首位，但可以作尾位
     * 2.大于6不能作尾位，但可以作首位
     * 优化建议：
     *   这个思路应该要更近一步，将其向下面的建议思路转化。将两个数转化为十进制数然后与26进行比较。
     * 将输入的字符串转换为char数组，数字的ASCII码，大写字母的ASCII码，小写字母的ASCII码。
     * 建议思路：
     *  1.将两个位置的字符划分出来，计算得到一个新的十进制数。如果大于26进行一个处理。
     *
     * */
    public static void main(String[] args) {
        // System.out.println("LCXYZ".compareTo("AWXYZ"));
        Scanner scanner = new Scanner(System.in);
        // 直接将字符串转换为字符数组
        char[] chars = scanner.nextLine().toCharArray();
        char[] ansChar = new char[200000];
        int i;
        for (i = 0; i < chars.length - 1; ) {
            int a = chars[i] - '0';
            //索引越界
            int b = chars[i + 1] - '0';
            int ans = a * 10 + b;
            if (ans < 27) {
                int s = ans + 64;
                System.out.print((char) s);
                //必须要后移两位。
                i += 2;
            } else {
                int s = a + 64;
                System.out.print((char) s);
                i++;
            }
        }
        // if (i < ansChar.length) {
        //     System.out.print((char) (ansChar[i] - '0' + 64));
        // }
    }

}
