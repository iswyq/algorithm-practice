# 稀疏数组

当一个数组中大部分的元素为0，或者为同一个值的数组时候，可以使用稀疏数组来保存该数组。

**处理方法**

1. 第一行保存原数组的行数和列数、共有多少个有效值。
2. 后面记录有效值所在位置、值

**应用**

1. 数组的压缩。可以在五子棋程序中应用。

**结构**

- 列的结构基本不变，行动态变化。

| row  | col  | val  |
| :--: | :--: | :--: |
|      |      |      |
|      |      |      |
|      |      |      |

**二维数组转稀疏数组思路**

1. 遍历原始的二维数组，保存有效数据的个数sum
2. 根据sum创建稀疏数组 `int[sum+1][3]`
3. 将原始的二维数组存储到稀疏数组

**稀疏数组转二维数组思路**

1. 读取稀疏数组的第一行，创建二维数组
2. 读取稀疏数组的后几行，将数据填入到二维数组当中。

# 数组保存

- 使用BuffererWriter进行文件写入，需要传入一个writer对象
- 调用该对象的write方法将数组写入到一行中

```java
BufferedWriter writer = new BufferedWriter(new FileWriter(file.getCanonicalPath(), true));
for (int i = 0; i < arr.length; i++) {
    writer.write(arr[i][0] + "," + arr[i][1] + "," + arr[i][2] + ",");
}
```

# 数组读取

- 使用BufferedReader进行数据读入
- 调用该对象的ReadLine将所有的数据读入到一行
- 使用String的Split方法得到String的数组。
- 解析到int数组

```java
BufferedReader reader = new BufferedReader(new FileReader(file.getCanonicalPath()));
String s1 = reader.readLine();
String[] split = s1.split(",");
```

1. 先解析为稀疏数组
2. 解析为二维数组

# 队列

队列可以通过数组和链表来实现。

**数组实现**

- 队头指针front  随着输出而改变。 指向队头的前一个元素
- 队尾指针rear  随着输入而改变。 指向队尾元素
- 队列为空：front=rear  队列满：rear=maxSize-1  

**环形队列**

1. 将队头指针front指向到队列的第一个元素
2. 将队尾指针rear指向队列最后元素的后一个位置
3. 队列为满：(rear+1)%maxSize =front 
4. 队列为空：front =rear
5. 队列中有效值的个数：(rear+front-maxSize)%maxSize
6. 对队列的实现进行如上的修改即可实现环形队列

