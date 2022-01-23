# 第十一届蓝桥杯JavaB组
https://blog.csdn.net/weixin_44949135/article/details/109402088
省赛第二场答案解析
https://blog.csdn.net/weixin_44949135/article/details/108228625
省赛第二场答案解析
## 门牌制作
正确答案：624个
## 寻找2020
正确答案：16520

索引越界异常的处理：
因为进行visited数组和字符数组遍历的时候，由于Node最开始的设计位置。一定会存在索引越界异常的问题。那么怎么来解决这个问题呢？通过将x和y的条件判断写在if条件语句的最前面。这样，如果x和y如果是不满足要求的话，那么后面的判断就不会进行；那么同样的，其产生IndexOutOfBoundsException就不会产生了。这一点真的就是学到了。以前上课的时候老师的确是有讲过这样的方式的；但那个时候没有多少体会，现在是真正的使用上了。在_05迷宫的if语句处可以看到。

```java
 if (x >= 0 && x < row && y >= 0 && y < column && arr[x][y] == 0 && visited[x][y] == 0){
   .......
 }
 //这里需要首先进行x与y的规范判断，这样可以避免上述记录的错误产生。
```
## 迷宫
正确答案 
```
DDDDRRURRRRRRDRRRRDDDLDDRDDDDDDDDDDDDRDDRRRUUURRRRDDDDRDRRRRRURRRDRRDDDRRRRUURUUUUUUUULLLUUUURRRRUULLLUUUULLUUULUURRURRURURRRDDRRRRRDDRRDDLLLDDRRDDRDDLDDDLLDDLLLDLDDDLDDRRRRRRRRRDDDDDDRR
DDDDRRURRRRRRDRRRRDDDLDDRDDDDDDDDDDDDRDDRRRURRUURRDDDDRDRRRRRRDRRURRDDDRRRRUURUUUUUUULULLUUUURRRRUULLLUUUULLUUULUURRURRURURRRDDRRRRRDDRRDDLLLDDRRDDRDDLDDDLLDDLLLDLDDDLDDRRRRRRRRRDDDDDDRR
```
## 单词分析
单词分析的代码里面有一个很巧妙的设计。设计了一个数组num用于存放次数。但是这个代码还可以存储次数所对应的字符。
整个分析如下：
1. 存放次数的解决：

   - 通过一个数组来搞定

     ```java
     nums[charArray[i] - 'a']+=1;
     ```

     将输入的字符串使用String类的toArray()方法将其转化为字符数组。nums[]数组用于存放单个字符的统计次数。如果charArray[i]为a，那么就是在nums数组的第一个位置进行操作。如果charArray[i]是c的话，就在第三个位置进行操作。这样的设计的妙处在于，不管charArray中的内容是什么，只要通过-'a'的操作，那么都可以实现在nums[]数组的对应位置进行操作。并且不管重复字符是否是联系的。而且保留了前面对于同一个位置操作的记录。

2. 将下标还原成对应的字符。

   - 通过读取下标i，然后再进行+1的操作；那么自然就将下标还原成了对应的字符。

整个单词分析的思路非常的妙！！
在成绩分析中涉及到了一个对于字符串的规范打印。可以使用String.format("%.2f")用以指定只有最后只保留两位小数。
在字符串分值和中，暂时还不明白为什么能够在不求解子串的情况下可以将他们子串的不同字符数给出来。暂时先记下来。
# 省赛第一场
## 合并检测
这是一个纯数学问题，直接进行求解，不用写代码。不过题意一开始拿到的时候**理解起来可能会有困难**。

需要作出他的表达式，然后利用基本不等式就可以做出来。

## 分类计数

将一串数字串进行一个良好的划分，使得这些数字分下来尽量都可以向26靠近（字典序最大）

在网上看到的比较好的解决思路是：将两个相互挨着的数提取出来，获得对应的十进制的数；将这个数与27进行比较，如果是大于27的话则不能合在一起，如果小于27则可以。

但是自己没有验证这样的思路在数组最后的一位或者是两位中是否有效。

<font color=#FF0000>在这里可以获得一个算法设计的经验：在稿纸上验证一下这个算法是否可行，然后再进行实现。多测几个数据。如果几个数据都是没有问题的，那么就算是通过了。在比赛中没有那么的时间进行数据的测试。</font>

自己将网上的代码进行了改进。针对如果是可以取两位数的话，则选择的是i+2操作。如果是只选择了一位数的话，则进行的是i+1的操作。而且对数组可能存在的索引越界异常在for循环指定上限的时候进行了处理。具体核心改变如下：

```java
for (i = 0; i < chars.length - 1; ) {
            int a = chars[i] - '0';
            //索引越界
            int b = chars[i + 1] - '0';
            int ans = a * 10 + b;
            if (ans < 27) {
                int s = ans + 64;
                System.out.print((char) s);
                //必须要后移两位。
                i += 2;
            } else {
                int s = a + 64;
                System.out.print((char) s);
                i++;
            }
        }
```

