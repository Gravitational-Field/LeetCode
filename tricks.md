## 1. 使用栈或者队列时

> 优先使用Deque的实现类，

```java
//需要查询多一点
Deque<Integer> deque = new ArrayDeque<>(len);

Deque<Integer> deque = new LinnkedList<>();

//其api如下
@Test
    public void dequeTest() {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(0);  //尾插
        deque.addFirst(5);
        deque.addFirst(4);
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        System.out.println(deque);  //[1, 2, 3, 4, 5, 0]
        deque.offerFirst(-1);
        deque.offer(-2);  //尾插
        deque.offerLast(-10);
        System.out.println(deque); //[-1, 1, 2, 3, 4, 5, 0, -2, -10]

        System.out.println(deque.pop());  //-1   前边是顶

        System.out.println(deque); //[1, 2, 3, 4, 5, 0, -2, -10]

        System.out.println(deque.peek());  //1
        System.out.println(deque.peekFirst());  //1
        System.out.println(deque.peekLast());  //-10

        System.out.println(deque.element());  //1   头

        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()) {
            int j = iterator.next();  //1 2 3 4 5 0 -2 -10
            System.out.print(j+" ");
        }

        System.out.println(deque.offer(0));  //true  插入成功   尾插
        System.out.println(deque);  //[1, 2, 3, 4, 5, 0, -2, -10, 0]
        System.out.println(deque.offerFirst(2)); //true
        System.out.println(deque); //  [2, 1, 2, 3, 4, 5, 0, -2, -10, 0]
        System.out.println(deque.offerLast(4)); //true
        System.out.println(deque);  //[2, 1, 2, 3, 4, 5, 0, -2, -10, 0, 4]

        System.out.println(deque.poll());  //2  头删
        System.out.println(deque);  // [1, 2, 3, 4, 5, 0, -2, -10, 0, 4]
        System.out.println(deque.pollFirst());  // 1
        System.out.println(deque);  // [2, 3, 4, 5, 0, -2, -10, 0, 4]
        System.out.println(deque.pollLast()); // 4
        System.out.println(deque);  // [2, 3, 4, 5, 0, -2, -10, 0]
    }
```



##  2. 数组的复制

```java
//将heights中的值从0下标开始，复制到newHeights的1下标开始，复制的个数为len
System.arraycopy(heights, 0, newHeights, 1, len);
```



## 3、稀奇古怪用法总结



```java
// 数组填充
Arrays.fill(array,-1);

//取一维数组中三个不同位置的值
for (int i = 0; i < nums.length-2; i++) {
    for (int j = i+1; j < nums.length-1; j++) {
        for (int k = j+1; k < nums.length; k++) {

        }
    }
}

//list中添加一个list
lists.add(Arrays.asList(nums[i],nums[L],nums[R]));

//set中添加一个list
set.add(list);

//hashSet进行add，返回add是否成功
while (hashSet.add(head)){
    
}

//Entry的创建方法
Map.Entry<String,Integer> entry = new AbstractMap.SimpleEntry<String, Integer>("exmpleString", 42); //可以直接进行实例化

//

```



## 4、技巧总结

### 4.1 数组和链表中

```
在数组处理中，存在一些暴力求解的方法，关键是使用好循环和判断，清楚该做什么
在链表的习题中，需要细心，先画图，理清过程，头结点什么时候构建，head一般是第一个节点。以及考虑问题可以使用递归的方式进行求解。
```

### 4.2 栈、队列、优先队列、双端队列

一般操作时，最好想一下是否可以使用栈或者队列进行解决问题；有时可以非常方便的解决一些暴力解法需要很费力问题。

**单调栈：**

解决下一个最大值问题：接雨水、最大矩形面积

单调递增栈：栈中的元素单调递增，当碰到小元素的情况，可以使用while循环，向前，保留当前元素来保证单增；并继续向后。

单调递减栈：栈中的元素单调递减，当碰到大元素的情况，可以使用while循环，向前，保留当前元素来保证单减；并继续向后。

```java
//单调递增栈： 一般会使用如下： 优势会增加哨兵，来避免在  进行计算区域  需要做复杂的判断进行排除
for(int i = 0; i<arr.length; i++) {
	
	while(!stack.isEmpty() && stack.peek()<arr[i]) {
        //进行计算
        
    }
	stack.push(arr[i]); //直至满足单调增，才push进去
}
```



**单调队列**

解决滑动窗口问题



# 5、格式化输出

```java
double d1 = 3.14158;
System.out.println(String.format("%.2f", d1));
System.out.printf("%.2f%n", d1);
```



