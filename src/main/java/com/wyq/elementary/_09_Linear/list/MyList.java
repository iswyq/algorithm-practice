package com.wyq.elementary._09_Linear.list;

/**
 * 自定义的线性表
 * 需要定义一个线性表的基本方法
 */
public interface MyList<T> {
    /*新增一个元素*/
    void add(T element);

    /*根据元素的值来删除元素*/
    void delete(T element);

    /*根据索引来删除元素*/
    void delete(int index);

    /*根据索引来更新元素*/
    void update(int index, T element);

    /**
     * 根据元素来查询是否存在
     *
     * @param element
     * @return
     */
    boolean contains(T element);

    /**
     * 返回index处的元素
     *
     * @param index
     * @return
     */
    int at(int index);

    /**
     * 根据元素返回索引，如果没有则返回-1
     *
     * @param element
     * @return
     */
    int indexOf(T element);
}
