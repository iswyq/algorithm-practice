package com.wyq.elementary._09_Linear.list;

/**
 * @program: algorithm-practice
 * @description: 线性表的节点
 * @author: Mr.Wang
 * @create: 2021-04-29 12:46
 **/
public class ListNode<T> {
    //存放数据
    T data;
    //存放前驱
    ListNode pre;
    //存放后继
    ListNode next;
    //对数据进行赋值的构造
    public ListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode getPre() {
        return pre;
    }

    public void setPre(ListNode pre) {
        this.pre = pre;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
