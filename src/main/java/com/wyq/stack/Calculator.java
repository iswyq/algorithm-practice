package com.wyq.stack;

/**
 * 使用栈实现计算器V1.0  只能实现一位数的计算
 * V2.0 完成多位数的计算
 *      修改逻辑：
 *          如果当前位置是数字时，则需要向后再看一位，
 *              1.如果后一位是操作符，则直接进行入栈
 *              2.如果是数字，那么还需要将其进行拼接  使用字符串拼接，然后使用Integer的方法转换为数字
 *          注意：索引越界  如果当前已经达到了expression的最后一位，则直接入栈
 */
public class Calculator {
    public static void main(String[] args) {
        //数值栈
        Arraystack2 numberStack = new Arraystack2(10);
        //符号栈
        Arraystack2 operStack = new Arraystack2(10);
        //待运算的表达式
        String expression = "70+20*6-3";
        //指向的索引
        int index = 0;
        //两个数值
        int num1 = 0;
        int num2 = 0;
        //操作符
        char ch;
        int oper;//存放符号栈弹出元素
        int res = 0;//运算结果
        String keepNum = "";//保存数值字符串
        //完成了* /的运算
        while (true) {
            //获得字符
            //获得了长度为1的字符串，使用charAt方法获取其字符
            ch = expression.substring(index, index + 1).charAt(0);

            //判断是否为运算符
            if (operStack.isOper(ch)) {
                //当前是符号
                //当符号栈为空时，那么可以直接入栈
                if (!operStack.isEmpty()) {
                    //符号栈不为空
                    /*
                     * 当前运算符与符号栈中的栈顶元素进行比较
                     * 1.当前运算符的优先级大于符号栈中栈顶元素的优先级 直接入栈
                     * 2.当前运算符的优先级小于符号栈中栈顶元素的优先级 将数值栈中的两个元素出栈，
                     *   符号栈中的元素出栈进行运算，将运算的结果入栈，再将当前符号入栈
                     * */
                    if (operStack.priority(ch) < operStack.priority(operStack.peek())) {
                        //当前操作符的优先级小于符号栈栈顶元素的优先级
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        oper = operStack.pop();
                        //计算结果
                        res = numberStack.cal(num1, num2, (char) oper);
                        //计算结果入栈
                        numberStack.push(res);
                        //符号入栈
                        operStack.push(ch);
                    } else {
                        //当前操作符的优先级大于符号栈栈顶元素的优先级
                        operStack.push(ch);
                    }
                } else {
                    //符号栈为空  符号直接入栈
                    operStack.push(ch);
                }
            } else {
                //当前是数值，直接入数值栈
                keepNum += ch;
                //如果当前index已经指向了expression的最后一位，则直接入栈  同时也解决了索引越界
                if (index == expression.length() - 1) {
                    //已经达到了最后一位
                    numberStack.push(Integer.parseInt(keepNum));
                } else {
                    //如果当前的位置是数值，则向后面看一位；如果是操作符，则直接进行入栈，否则进行拼接
                    //使用子字符串就是开始位置就是 index+1
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //是操作符
                        //将数值字符串转换为数字
                        numberStack.push(Integer.parseInt(keepNum));
                        //清空字符串
                        keepNum = "";
                    }
                }
            }
            index++;
            //index指向到了表达式的最后  也有效防止了索引越界
            if (index >= expression.length()) {
                break;
            }
        }
        //进行加减运算
        while (true) {
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            oper = operStack.pop();
            res = numberStack.cal(num1, num2, (char) oper);
            //计算后的结果一定要再次入栈，否则前面的代码不能复用
            numberStack.push(res);
            //当符号栈中为空时，那么数值栈中只有一个元素
            if (operStack.isEmpty()) {
                break;
            }
        }
        System.out.printf("表达式%s的结果=%d", expression, numberStack.peek());
    }
}

class Arraystack2 {
    public int maxSize;
    public int[] stack;
    public int top = -1;//top表示栈顶，初始化为-1

    public Arraystack2(int maxSize) {
        this.maxSize = maxSize;
        //进行栈的初始化
        stack = new int[maxSize];
    }

    //获取到当前栈顶元素 不弹栈
    public int peek() {
        return stack[top];
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

    //获得操作符的优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断一个符号是否是操作符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //对两个数通过操作符进行运算
    public int cal(int num1, int num2, char oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num2 + num1;
                break;

            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
