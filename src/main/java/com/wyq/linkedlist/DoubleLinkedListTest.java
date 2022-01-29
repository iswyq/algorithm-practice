package com.wyq.linkedlist;

/**
 * 双向链表测试
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        Node2 hero1 = new Node2(1, "宋江", "及时雨");
        Node2 hero2 = new Node2(2, "卢俊义", "玉麒麟");
        Node2 hero3 = new Node2(3, "吴用", "智多星");
        Node2 hero4 = new Node2(4, "林冲", "豹子头");

        //节点添加
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        System.out.println("链表信息打印");
        doubleLinkedList.list();

        //修改链表信息
        Node2 newNode = new Node2(2,"小卢","玉麒麟~~");
        System.out.println("修改后链表信息打印");
        doubleLinkedList.update(newNode);
        doubleLinkedList.list();

        //删除节点
        doubleLinkedList.deleNode(2);
        System.out.println("删除后链表信息打印");
        doubleLinkedList.list();


    }
}
