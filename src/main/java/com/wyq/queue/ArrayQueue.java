package com.wyq.queue;

/**
 * 使用数组实现队列
 */
public class ArrayQueue {
    public static void main(String[] args) {
        Queue queue = new Queue(2);

    }
}

//使用数组实现普通队列
class Queue {
    private int maxSize;//队列的最大长度
    private int front = -1;//队头指针
    private int rear = -1;//队尾指针
    private int[] arr;//存储数据的数组

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //1.判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //2.判断队列是否满了
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //向队列中增加元素
    public void addQueue(int n) {
        //队列满后不可以添加
        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加~~");
        }
        //队尾指针后移
        rear++;
        arr[rear] = n;
        return;
    }

    //获取队列元素，出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取");
        }
        //队头指针后移
        front++;
        return arr[front];
    }

    //显示队列中的所有元素
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法显示所有元素");
        }
        for (int i = 0; i < maxSize; i++) {
            System.out.printf("arr[%d]=%d", i, arr[i]);
        }
    }

    public int head() {
        return arr[front + 1];
    }
}

class CircleQueue {
    private int maxSize;//队列的最大长度
    private int front = 0;//队头指针
    private int rear = 0;//队尾指针
    private int[] arr;//存储数据的数组

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    //添加元素
    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列以满，无法添加");
        }
        arr[rear] = n;

        rear = (rear + 1) % maxSize;
    }

    //返回头元素
    public int getEle() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取元素");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示所有元素
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法显示所有元素");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d", i % maxSize, arr[i % maxSize]);
        }
    }

    //返回队列中有效值的个数
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    public int head() {
        return arr[front];
    }
}
