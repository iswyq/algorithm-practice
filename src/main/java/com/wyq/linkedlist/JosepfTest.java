package com.wyq.linkedlist;

/**
 * 约瑟夫的环
 */
public class JosepfTest {
    public static void main(String[] args) {
        CircleJosepf josepf = new CircleJosepf();
        josepf.add(4);
        josepf.showBoy();
    }
}

//约瑟夫环
class CircleJosepf {
    //构建第一个节点
    Boy first = null;

    //增加节点 指定增加nums个节点
    public void add(int nums) {
        //定义辅助节点
        Boy cur = null;
        if (nums < 2) {
            System.out.println("nums不正确");
        }
        //使用for循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);

            //如果是第一个节点，则自己形成环
            if (i == 1) {
                first = boy;
                //first指向boy
                first.setNext(boy);
                //cur向后移动 指向第一个小孩
                cur = first;
            } else {
                //cur指向新建的小孩
                cur.setNext(boy);
                //新建节点指向first
                boy.setNext(first);
                //将cur向后移动
                cur = boy;
            }
        }
    }

    //遍历环形链表
    public void showBoy() {
        Boy cur = first;
        //如果是空链表
        if (first == null) {
            System.out.println("链表为空，无法打印");
        }
        while (true) {

            System.out.printf("小孩编号为%d\n", cur.getNo());

            //cur重新指向first时，就完成了整个遍历
            if (cur.getNext()== first) {
                break;
            }
            //cur向后移动
            cur = cur.getNext();
        }
    }
}

//约瑟夫环中的节点Boy
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
