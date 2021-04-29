package com.wyq.cc150;

import java.util.ArrayList;

/**
 * @program: algorithm-practice
 * @description: 全排列1
 * @author: Mr.Wang
 * @create: 2021-04-29 19:10
 **/
public class _01全排列1 {
    /*使用迭代法进行全排列*/
    private static ArrayList<String> f(String str) {
        //要返回的list
        ArrayList<String> res = new ArrayList<>();
        //将第一个字符加入到集合中
        res.add(str.charAt(0) + "");
        // 将每一个字符加入到每个元素中
        for (int i = 1; i < str.length(); i++) {
            ArrayList<String> newStrList = new ArrayList<>();
            char c = str.charAt(i);
            for (String s :
                    res) {
                //字符在后面
                String string = s + c;
                newStrList.add(string);
                //字符在前面
                string = c + s;
                newStrList.add(string);
                //字符在中间
                //这里遍历的是从list集合中取出来的s，类型为String。切记切记
                for (int j = 1; j < s.length(); j++) {
                    string = s.substring(0, j) + c + s.substring(j);
                    newStrList.add(string);
                }
            }
            //进行数据更新
            res = newStrList;
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> list = f("abcd");
        for (String str :
                list) {
            System.out.println(str);

        }
    }
}