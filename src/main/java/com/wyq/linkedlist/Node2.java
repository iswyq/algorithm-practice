package com.wyq.linkedlist;

/**
 * 双向链表的节点
 */
public class Node2 {
    public int no;
    public String name;
    public String nickName;
    public Node2 next; //指向下一个节点
    public Node2 pre;//指向前一个节点

    public Node2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
