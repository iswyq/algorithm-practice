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
        String expression = "1+((20+3)*5)-5";
        /*
         * 将后缀表达式放到List中去
         * */
        List<String> list = toInfixExpressionList(expression);
        List<String> lst = getListString(suffixExpression);
        List<String> suffixList = parseSuffixExpressionList(list);
        System.out.println(list);
        System.out.println(suffixList);
        int res = claculate(suffixList);
        System.out.println("计算结果为=" + res);
    }

    //转换为后缀表达式
    public static List<String> parseSuffixExpressionList(List<String> list) {
        //符号栈s1
        Stack<String> s1 = new Stack<>();
        //中间结果s2
        ArrayList<String> s2 = new ArrayList<>();
        for (String item : list) {
            //如果遇到操作数 则直接入栈
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                //如果是遇到( ,则直接入栈
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是遇到),则一直寻找，直到找到(   匹配一对括号
                while (!s1.peek().equals("(")) {
                    //没有遇到(,则一直while循环
                    s2.add(s1.pop());
                }
                //对s1的(出栈
                s1.pop();
            } else {
                //如果遇到运算符，比较运算符的优先级
                //优先级小于栈顶元素优先级，将s1栈顶的运算符弹出并压入到s2中，再次转到4.1与s1中心的栈顶运算符相比较
                while (s1.size() != 0 && Operation.getValue(s1.peek()) > Operation.getValue(item)) {
                    //比较s1栈顶元素与当前元素的优先级
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //将s1中的元素出栈到s2中
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    //获得中缀表达式的list集合
    public static List<String> toInfixExpressionList(String stringExpression) {
        ArrayList<String> list = new ArrayList<>();
        char ch;
        String str = "";
        int index;
        int i = 0;//i用于字符串遍历的索引
        while (i < stringExpression.length()) {
            ch = stringExpression.charAt(i);
            //当前字符是一个数字
            if (ch < 48 || ch > 57) {
                list.add("" + ch);
                i++;
            } else {
                //str置空
                str = "";
                while (i < stringExpression.length() && stringExpression.charAt(i) >= 48 && stringExpression.charAt(i) <= 57) {
                    str += stringExpression.charAt(i);
                    i++;
                }
                list.add(str);
            }
        }
        return list;
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

//比较运算符优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String str) {
        int res = 0;
        switch (str) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.println("没有该运算符，无法操作");
                break;
        }
        return res;

    }
}