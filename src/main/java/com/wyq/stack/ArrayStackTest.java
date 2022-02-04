package com.wyq.stack;

/**
 * 使用数组来实现栈
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        Arraystack stack = new Arraystack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.list();
    }
}

class Arraystack {
    public int maxSize;
    public int[] stack;
    public int top = -1;//top表示栈顶，初始化为-1

    public Arraystack(int maxSize) {
        this.maxSize = maxSize;
        //进行栈的初始化
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i > -1; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
