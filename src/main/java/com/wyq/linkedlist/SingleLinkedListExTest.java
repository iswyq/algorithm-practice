package com.wyq.linkedlist;

import java.util.Stack;

/**
 * 大厂单链表的面试题
 */
public class SingleLinkedListExTest {
    public static void main(String[] args) {
        Node hero1 = new Node(1, "宋江", "及时雨");
        Node hero2 = new Node(2, "卢俊义", "玉麒麟");
        Node hero3 = new Node(3, "吴用", "智多星");
        Node hero4 = new Node(4, "林冲", "豹子头");
        //获取单链表有效节点的个数 不包含头结点
        SingleLinkedListEx linkedListEx = new SingleLinkedListEx();
        linkedListEx.addByOrder(hero1);
        linkedListEx.addByOrder(hero3);
        linkedListEx.addByOrder(hero2);
        linkedListEx.addByOrder(hero4);
        System.out.println("原链表的值：");
        linkedListEx.list();
        //进行链表反转
        linkedListEx.reverseLinkedList(linkedListEx.getHead());
        System.out.println("链表反转后~");
        linkedListEx.list();
        System.out.println("链表逆序打印，不改变链表结构~");
        linkedListEx.reversePrint(linkedListEx.getHead());
/*        int res = linkedListEx.count(linkedListEx.getHead());
        linkedListEx.list();
        System.out.printf("当前链表的有效节点个数为%d\n", res);
        //查找单链表中的倒数第k个节点
        Node lastIndexNode = linkedListEx.findLastIndexNode(linkedListEx.getHead(), 3);
        System.out.println("res=" + lastIndexNode);*/

    }
}

class SingleLinkedListEx {
    private Node head = new Node(1, "", "");//head节点

    //返回head节点
    public Node getHead() {
        return head;
    }

    //返回链表有效值的个数 不包含头结点
    public int count(Node head) {
        Node cur = head;
        int num = 0;//节点个数
        while (true) {
            //指向到了链表的最后
            if (cur.next == null || cur == null) {
                break;
            }
            //节点后移
            cur = cur.next;
            num++;
        }
        return num;
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

    //获得倒数第k个节点(新浪面试题)
    public Node findLastIndexNode(Node head, int index) {
        Node cur = head.next;
        //链表为空
        if (cur == null || cur.next == null) {
            return null;
        }
        int sum = count(head);
        if (index <= 0 || index > sum) {
            return null;
        }
        for (int i = 0; i < sum - index; i++) {
            cur = cur.next;
        }
        return cur;

    }

    //将单链表进行反转(腾讯面试题) 不需要返回值，只要head在内存中指向已经反转后的链表即可
    public void reverseLinkedList(Node head) {
        //链表为空或当前链表只有一个节点无需反转
        if (head.next == null || head.next.next == null) {
            return;
        }
        //对原链表进行正向遍历
        Node cur = head.next;
        Node next = null;
        //反转链表的头节点  这个是不可以动的
        Node reverseHead = new Node(0, "", "");
        //反向链表的head节点的临时变量
        Node temp = reverseHead;
        while (cur != null) {
            //将当前节点的下一个节点保存下来
            next = cur.next;
            //将cur下一个节点指向反向链表的最前端
            cur.next = temp.next;
            //反向链表的头向前移动
            temp.next = cur;
            //让cur后移
            cur = next;
        }
        //head指向反向链表的头
        head.next = reverseHead.next;
    }
    //链表逆序打印 百度
    public void reversePrint(Node head){
        Stack<Node> nodeStack = new Stack<>();
        Node cur = head;
        while (cur.next!=null){
            nodeStack.push(cur.next);
            cur = cur.next;
        }
        while (nodeStack.size()!=0){
            System.out.println(nodeStack.pop());
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
