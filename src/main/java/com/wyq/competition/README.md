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