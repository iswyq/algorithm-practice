package com.wyq.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 使用逆波兰表达式(后缀表达式)实实现计算器
 */
public class PolandNotation {
    public static void main(String[] args) {
        //(30+4)*5-6
        String suffixExpression = "30 4 + 5 * 6 -";//后缀表达式
        /*
         * 将后缀表达式放到List中去
         * */
        List<String> lst = getListString(suffixExpression);
        int res = claculate(lst);
        System.out.println("计算结果为=" + res);
    }

    //进行计算
    private static int claculate(List<String> lst) {
        Stack<String> stack = new Stack<>();
        //遍历list
        for (String item : lst) {
            //使用正则表达式匹配数字 \d匹配数字
            if (item.matches("\\d+")) {
                //直接入栈
                stack.push(item);
            } else {
                //出栈并进行计算
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;//返回的结果
                if (item.equals("+")) {
                    res = num2 + num1;
                } else if (item.equals("-")) {
                    res = num2 - num1;
                } else if (item.equals("*")) {
                    res = num2 * num1;
                } else if (item.equals("/")) {
                    res = num2 / num1;
                } else {
                    //处理其他的一些错误
                    throw new RuntimeException("运算符错误");
                }

                //完成计算后的结果需要入栈
                stack.push("" + res);
            }

        }
        //栈最后只有一个计算的结果
        return Integer.parseInt(stack.pop());
    }

    //将字符串中的每一个字符放置到数组中
    private static List<String> getListString(String suffixExpression) {
        //使用空格对字符串进行分割
        String[] strings = suffixExpression.split(" ");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String string :
                strings) {
            arrayList.add(string);
        }
        return arrayList;

    }

}
