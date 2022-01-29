package com.wyq.linkedlist;

/**
 * 双向链表
 */
public class DoubleLinkedList {
    //新建节点
    public Node2 head = new Node2(0, "", "");

    //增加节点
    public void add(Node2 newNode) {
        Node2 temp = head;
        //向后进行链表遍历
        while (temp.next != null) {
            //temp节点后移
            temp = temp.next;
        }
        //链表最后节点指向新节点
        temp.next = newNode;
        //新节点指向链表最后节点
        newNode.pre = temp.next;
    }

    //遍历链表
    public void list() {
        Node2 temp = head.next;
        if (temp.next == null) {
            System.out.println("链表为空，无法遍历");
            return;
        }

        while (temp!= null) {
            System.out.println(temp);
            //temp向后移动
            temp = temp.next;
        }
    }

    //修改链表节点
    public void update(Node2 newNode) {
        Node2 temp = head;
        //是否找到了待修改的节点
        boolean flag = false;
        //
        while (true) {
            //如果遍历到了链表的最后
            if (temp.next == null) {
                break;
            }
            if (temp.no == newNode.no) {
                flag = true;
                break;
            }
            //temp后移
            temp = temp.next;
        }
        if (flag){
            temp.name=newNode.name;
            temp.nickName=newNode.nickName;
        }else {
            System.out.printf("编号为%d的节点没有找到,无法进行修改\n", newNode.no);
        }
    }

    //删除链表
    public void deleNode(int no) {
        Node2 temp = head;
        //是否找到了节点
        boolean flag = false;
        while (true) {
            //达到链表的最后
            if (temp.next == null) {
                break;
            }
            //找到待删除节点的前一个节点
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            //节点后移
            temp = temp.next;
        }

        if (flag) {
            //前一个节点指向待删除节点的后一个节点
            temp.next = temp.next.next;
        } else {
            System.out.printf("编号为%d的节点不存在，无法删除\n", no);
        }
    }
}
