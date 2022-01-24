package com.wyq.linkedlist;

public class SingleLinkedList {
    public Node head = new Node(1, "", "");//head节点

    //无顺序添加节点
    public void addNode(Node node) {
        //head节点不能头，找一个临时可操作节点
        Node temp = head;
        //添加到链表的尾部
        while (true) {
            //next为null，则为最后的节点
            if (temp.next == null) {
                //跳出循环
                break;
            }
            //指针后移
            temp = temp.next;
        }
        //完成节点添加
        temp.next = node;
    }

    //有顺序添加节点
    public void addByOrder(Node node) {
        //临时节点
        Node temp = head;
        //待插入的节点不存在
        boolean flag = false;
        //遍历链表，拿到插入位置的前一个节点
        while (true) {
            //链表的最后 使用next指向空为链表最后
            if (temp.next == null) {//使用next作为判断是为了防止后面一个if空指针异常
                break;
            }
            //拿到了插入位置的前一个节点
            if (temp.next.no > node.no) {
                break;
            }
            //插入的值已经存在
            if (temp.next.no == node.no) {
                //改变flag
                flag = true;
                break;
            }
            //节点移动
            temp = temp.next;
        }
        //待添加节点已经存在，不能进行添加
        if (flag) {
            System.out.printf("节点%d已经存在，添加失败\n", temp.no);
            return;
        }
        //新节点指向后一个节点
        node.next = temp.next;
        //前一个节点指向新节点
        temp.next = node;
        System.out.printf("节点%d添加成功\n", temp.next.no);
    }

    //修改节点信息
    public void updateNode(Node newNode) {
        //临时变量
        Node temp = head;
        //待修改的节点是否找到
        boolean flag = false;
        while (true) {
            //达到链表最后
            if (temp.next == null) {
                break;
            }
            //找到待修改节点
            if (temp.no == newNode.no) {
                flag = true;
                break;
            }
            //节点后移
            temp = temp.next;
        }
        //修改节点信息
        if (flag) {
            temp.name = newNode.name;
            temp.nickName = newNode.nickName;
        } else {
            System.out.printf("编号为%d的节点没有找到,无法进行修改\n", newNode.no);
        }
    }

    //删除节点
    public void deleNode(int no) {
        Node temp = head;
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

    //遍历节点
    public void list() {
        //定义临时变量
        Node temp = head.next;
        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            //打印当前节点
            System.out.println(temp);
            //节点向后移动
            temp = temp.next;
        }
    }
}
