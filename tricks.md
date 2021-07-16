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



## 3、

稀奇古怪用法总结

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
```

