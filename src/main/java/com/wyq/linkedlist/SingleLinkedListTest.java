package com.wyq.linkedlist;

/**
 * 单链表
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        //1.创建节点
        Node hero1 = new Node(1, "宋江", "及时雨");
        Node hero2 = new Node(2, "卢俊义", "玉麒麟");
        Node hero3 = new Node(3, "吴用", "智多星");
        Node hero4 = new Node(4, "林冲", "豹子头");
        //2.新建链表
        SingleLinkedList linkedList = new SingleLinkedList();
//        linkedList.addNode(hero1);
//        linkedList.addNode(hero2);
//        linkedList.addNode(hero3);
//        linkedList.addNode(hero4);
        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero4);
        linkedList.list();
        //定义新节点
        Node newNode = new Node(2, "小卢", "玉麒麟~~");
        linkedList.updateNode(newNode);
        System.out.println("修改后的节点信息");
        linkedList.list();
        linkedList.deleNode(2);
        System.out.println("删除节点后进行打印~~");
        linkedList.list();
    }
}