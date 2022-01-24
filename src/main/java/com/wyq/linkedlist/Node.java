package com.wyq.linkedlist;

/**
 * 链表的节点
 */
public class Node {
    public int no;
    public String name;
    public String nickName;
    public Node next; //指向下一个节点

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
