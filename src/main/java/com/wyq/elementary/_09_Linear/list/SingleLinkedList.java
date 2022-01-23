package com.wyq.elementary._09_Linear.list;

/**
 * @program: algorithm-practice
 * @description: 单向链表
 * @author: Mr.Wang
 * @create: 2021-04-29 12:56
 **/
public class SingleLinkedList implements MyList {
    /*
     * 通常first是保持不变的
     * */
    //头指针
    private ListNode first;
    //尾指针
    private ListNode last;
    //List的大小
    private int size;

    @Override
    public void add(Object element) {
        /*增加一个元素：
         * 1.需要判断当前链表中是否已经存在元素了
         * 2.已经存在的情况下，需要新建一个节点，加入到整个链表当中
         * */
    }

    @Override
    public void delete(Object element) {

    }

    @Override
    public void delete(int index) {

    }

    @Override
    public void update(int index, Object element) {

    }

    @Override
    public boolean contains(Object element) {
        return false;
    }

    @Override
    public int at(int index) {
        return 0;
    }

    @Override
    public int indexOf(Object element) {
        return 0;
    }
}
