# 0. 数据结构

[数组与字符串](https://leetcode-cn.com/leetbook/detail/array-and-string/)—>[队列和栈](https://leetcode-cn.com/leetbook/detail/queue-stack/)—>[链表](https://leetcode-cn.com/leetbook/detail/linked-list/) —> [二叉树](https://leetcode-cn.com/leetbook/detail/data-structure-binary-tree/)

# 1. Array 

## 实战题目

#### [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)（最大水面积）


```java
class Solution { //java实现
    public int maxArea(int[] height) {
        //最大水容量，双指针
        if (height == null || height.length==0) {
            return 0;
        }
        int max_area = 0;
        int area = 0;
        int j = height.length-1;
        for (int i = 0; i < j; i++) {//当不考虑i逐步递进时，可以考虑使用while循环！！！
            //i指头，j指尾
            area = (j-i) * Math.min(height[i],height[j]);
            //前边的大，则后边指针j前移
            if (height[i]>=height[j]) {
                i--; //保证i指针不后移
                j--; //确保j指针向前移
            }
            max_area = Math.max(max_area, area);

        }

        return max_area;
    }
}
```



#### [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)

```java
//java
class Solution {
    public void moveZeroes(int[] nums)  {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            //i进行后续探索，j进行延后的定位，始终指向下一个存储位置
            if (nums[i] != 0) {//非0，则进行交换
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
```



#### [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

- 自底向上

```java
protected int climbStairs(int n) {
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        if (1==n){
            return f1;
        }else if (2==n){
            return f2;
        }
        for (int i = 2; i < n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
}
```



#### [剑指 Offer 10- I. 斐波那契数列](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)

- 纯递归，会超出时间限制

```java

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fib(n-1)+fib(n-2);
}
```

- 带备忘录的递归

```java
public int fib1(int n) {
        //备忘录数组
        Integer[] array = new Integer[n+1];
        Arrays.fill(array,-1);

        return process(n,array);
    }

    private int process(int n, Integer[] array) {
        if (n==0) return 0;
        if (n==1) return 1;
        if (array[n] != -1) {  //巧妙之处
            return array[n];
        }
        array[n] = (process(n-1,array) + process(n-2,array))%1000000007;

        return array[n];
}
```

- dp数组迭代解法

```java
//dp数组迭代解法
public int fib2(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        //备忘录数组
        Integer[] array = new Integer[n+1];
        Arrays.fill(array,-1);

        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = (array[i-1] + array[i-2])%1000000007;
        }
        return array[n];
}
```

- 

```java
//dp解法，压缩空间
    public int fib3(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        //备忘录数组
        int a = 0;
        int b = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = (a+b)%1000000007;
            a = b;
            b = fib;
        }
        return b;
}
```



#### [1. 两数之和](https://leetcode-cn.com/problems/two-sum/) (两数之和)

```java
//java
class Solution {
    //数组中同一个元素不能使用两遍: 没有重复元素，且不能输出相同的下标。最终要返回两个下标
    public int[] twoSum(int[] nums, int target) {//对于返回下标的题可以考虑HashMap
        if (nums == null || nums.length == 0){
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>(); //存储nums[i],i
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp = target-nums[i];
            if (map.containsKey(tmp)){
                return new int[]{i,map.get(tmp)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
class Solution3 { //66ms 39.9M
    //数组中同一个元素不能使用两遍: 没有重复元素，且不能输出相同的下标。最终要返回两个下标
    public int[] twoSum(int[] nums, int target) {//对于返回下标的题可以考虑
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        int[] arr = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
            
        }

        return new int[0];
    }
}
```





#### [15. 三数之和](https://leetcode-cn.com/problems/3sum/)  (高频老题） 

```java
//java
class Solution4 {
    public List<List<Integer>> threeSum(int[] nums) {
        //注意：答案中不可以包含重复的三元组。需要排序处理
        //非返回索引，可以排序
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length<3) {
            return lists;
        }
        Arrays.sort(nums);


        //法1：暴力求解
        /*HashSet<List<Integer>> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        hashSet.add(list);
                    }
                }
            }
        }
        for (List<Integer> list: hashSet) {
            lists.add(list);
        }*/
        //法2：三指针
        for (int i = 0; i < nums.length; i++) {
            //判断首位，首位大于0，则没有满足的
            if (nums[i] > 0) {
                break;
            }
            //
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int L = i+1;
            int R = nums.length-1;
            while (L< R){
                //进行判断
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0){
                    lists.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    //分别去重
                    while(L<R && nums[L]==nums[L+1]) L++;
                    while (R>L && nums[R]==nums[R-1]) R--;
                    //去重之后，再移一位
                    L++;
                    R--;
                }else if (sum < 0){
                    L++;
                }else if (sum>0){
                    R--;
                }
            }
        }
        return lists;
    }
}
```

# 2. Linked List 

## 实战题目

#### [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)


```java
class Solution {//画个图就出来了
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null){
            ListNode tmp = pre.next; //探索者
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }
}

//递归的方式
```



#### [24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

```java
class Solution {
    public ListNode swapPairs(ListNode head) { //实际上使用了四个指针
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {  //头插法
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}
```



#### [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashSet<ListNode> hashSet = new HashSet<>();

        while (hashSet.add(head)){
            head = head.next;
            if (head == null){
                return false;
            }
        }
		
        return true;
    }
}
```



#### [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

```java
class Solution2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) { //只能有一个退出循环条件
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
```



#### [25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)

```java
class Solution21 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode pre = temp;
        ListNode end = temp;
        while (end.next != null) {
            ListNode start = pre.next;
            for (int i = 0; i<k && end!=null ; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode endNext = end.next;
            end.next = null;
            pre.next = reverse(start);
            //start此时已经是内部链表的尾部
            start.next = endNext;
            pre = start;
            end = start;
        }

        return temp.next;
    }

    private ListNode reverse(ListNode head) {
        //TODO:完成链表翻转，不需要使用头插法
        ListNode cur = null;    // cur - pre - tmp
        ListNode pre = head;
        while (pre != null){
            ListNode tmp = pre.next; //探索者
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }
}
```



## 课后作业

#### [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;// p进行保留
        int q = 1;//探索者

        while(q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p+1] = nums[q];
                p++;
            }
            q++;
        }
        return p+1;
    }
}

class Solution11 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length==0) {
            return 0;
        }
        int low = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[low]) {
                low++;
                nums[low] = nums[i];
            }
        }

        return low+1;
    }
}
```

#### [189. 旋转数组](https://leetcode-cn.com/problems/rotate-array/)

```java
class Solution20 {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if (nums.length == 0 || nums == null) {
            return;
        }
        int tem = 0;
        for (int i = 0; i < k; i++) {
            //每轮向右移动一位
            nums = rotate(nums);
        }
    }

    public int[] rotate(int[] nums) {
        int tmp = 0;
        tmp = nums[nums.length-1];
        for (int i = nums.length-1; i > 0; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = tmp;
        return nums;
    }
}
```



#### [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

- 合并两个有序链表   【递归】

```java
//java
//1. 固有思路
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();
        ListNode returnHead = new ListNode();
        head.next = l1;
        returnHead = head;
        ListNode tmp = null;
        while (l2 != null && l1 != null) {
            if (l1.val >= l2.val) {//l2插进来
                tmp = l2.next;
                l2.next = l1;
                head.next = l2;
                head = l2;
                l2 = tmp;
                
            }else{ //l1.val < l2.val  l1后移一位
                head = l1;
                l1 = l1.next;
            }
        }
        if (l1==null) {
            head.next = l2;
        }

        return returnHead.next;
    }
}

//递归思路
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) {
        return l2;
    }
    if(l2 == null) {
        return l1;
    }

    if(l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
```

#### [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

```java
// 1.调用官方api
public void merge(int[] nums1, int m, int[] nums2, int n) {
    System.arraycopy(nums2,0,nums1,m,n);
    Arrays.sort(nums1);
}
// 2. 借助m个空间进行探索
public static void merge2(int[] nums1, int m, int[] nums2, int n) {
    //借助m个空间
    int[] arr = new int[m];
    System.arraycopy(nums1,0,arr,0,m);
    int i = 0; //arr
    int j = 0; //nums2
    int k = 0; //nums1
    while (i<m && j<n) {
        if (arr[i]<nums2[j]) {
            nums1[k++] = arr[i++];
        }else {
            nums1[k++] = nums2[j++];
        }
    }
    if (i<m) {
        //此时nums2已经完成
        System.arraycopy(arr,i,nums1,i+j,m+n-i-j);
    }
    if (j<n) {
        //此时arr已经完成，可以省略，因为num1后面是剩下的排好序的数组，故可以不用管
        System.arraycopy(nums2,j,nums1,i+j,m+n-i-j);
    }
}
// 3.不借助空间，直接从nums1的后边进行插入
public static void merge3(int[] nums1, int m, int[] nums2, int n) {
    //不借助空间，直接从nums1的后面插
    int p1 = m-1; //记录nums1的比较节点
    int p2 = n-1; //记录nums2的比较节点
    int p = nums1.length-1; //
    while (p1>=0 && p2>=0) {
        if (nums1[p1] > nums2[p2]) {
            nums1[p--] = nums1[p1--];
        }else {
            nums1[p--] = nums2[p2--];
        }
    }
    if (p1<0) {
        //将nums2剩下的补齐
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }
    if (p2<0) {
        //p1不用管
    }
}
```



#### [66. 加一](https://leetcode-cn.com/problems/plus-one/)

```java
//java
public int[] plusOne(int[] digits) {
    for (int i = digits.length-1; i >= 0; i--) {
        digits[i]++;
        digits[i] = digits[i]%10;
        //什么时候需要进位？ digits[i]+1==10时，进行进位
        if (digits[i]!=0) return digits;
    }
    digits = new int[digits.length+1];
    digits[0] = 1;
    return digits;
}
```



# 3. 栈、队列、优先队列、双端队列

#### [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)

```java
public static boolean isValid(String s) {
    if (s.length()%2==1)    return false;

    Stack<Character> stack = new Stack();
    for (char c:s.toCharArray()) {
        if (c == '(') {
            stack.push(')');
        } else if (c == '[') {
            stack.push(']');
        } else if (c == '{') {
            stack.push('}');
        } else if (stack.isEmpty() || c != stack.pop()) {
            return false;
        }
    }

    return stack.isEmpty() ;
}
```

#### [155. 最小栈](https://leetcode-cn.com/problems/min-stack/)

![image-20210301204447202](img/01-basic/image-20210301204447202.png)

> 两种思路：
>
> 1. stack中存入entry<key, value>，key为值，value为当前min，始终保证stack.peek().getValue() 最小；  **PS：需要实现Entry接口**
> 2. 利用辅助栈，保持miniStack中栈顶为最小；  PS：要注意push进miniStack的边界值，以及pop，这两一定需统一来保持数据的一致

- stack中存储entry<key, value>，key为值，value为当前min

```java
class MinStack {

    private Deque<SEntry<Integer, Integer>> deque = new LinkedList<>();

    /** initialize your data structure here. */
    public MinStack() {
    }
    
   public class SEntry<K,V> implements Map.Entry<K,V> {  //实现Entry
        private K key;
        private V value;

        public SEntry(K k, V v) {
            key = k;
            value = v;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return this.value;
        }
    }

    public void push(int x) {
        SEntry<Integer, Integer> entry = null;
        if (deque.isEmpty()) {
            entry = new SEntry<>(x,x);
        }else {
            //deque不空
            int min = deque.peek().getValue();
            if (x < min) {
                min = x;
            }
            entry = new SEntry<>(x,min);
        }
        deque.push(entry);
    }

    public void pop() {
        //从栈顶pop出，并要求最小值也在栈顶
        if (deque.isEmpty()) {
            return;
        }
        //不为空，直接pop
        deque.pop();   //保证栈顶的getValue始终是栈中的最小
    }

    public int top() {
        return deque.peek().getKey();
    }

    public int getMin() {
        //遍历一遍，再进行
        return deque.peek().getValue();
    }
}
```

- 辅助栈法

```java
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        /*if (!minStack.isEmpty()) {
                if (x <= minStack.peek()) {
                    minStack.push(x);
                }
            }else {
                minStack.push(x);
            }*/
        if (minStack.isEmpty()) {
            minStack.push(x);
        }else {
            //不为空
            if (x <= minStack.peek()) {  //注意这里是相等，为了保证pop时一致性
                minStack.push(x);
            }
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (pop == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
```



## 实战题目

#### [84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)

![image-20210302154233626](img/01-basic/image-20210302154233626.png)

>以高为准，进行求解，暴力解法是依次遍历当前高，再左找、右找确定当前高所能获得的最大的宽，遍历下去即可获得最大的面积。  PS:但是容易超时。

题解：[暴力解法、单调栈+哨兵技巧](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/)

- 暴力解法超出了时间限制（遍历高）

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int maxArea = 0;
        //遍历高，左右找比其小的，看面积
        for (int i = 0; i < heights.length; i++) {
            //以一个高位基,因为要左右摇摆，所以不能用forj遍历
            //先左
            int left = i;
            int currentHeight = heights[i];
            while (left>0 && heights[left-1] >= currentHeight) {
                left--;
            }

            //后右
            int right = i;
            while (right<heights.length-1 && heights[right+1] >= currentHeight) {
                right++;
            }

            int width = right-left+1;
            maxArea = Math.max(maxArea, width * currentHeight);
        }

        return maxArea;
    }
}
```

- 单调栈+哨兵技巧

> 单调栈：我们在缓存数据的时候，是从左向右缓存的，我们计算出一个结果的顺序是从右向左的，并且计算完成以后我们就不再需要了，符合后进先出的特点。因此，我们需要的这个作为缓存的数据结构就是栈。
>
> 哨兵体现在 左右各安排一个最小值，可排除特殊情况，保持一致的处理。
>
> ​		左边的柱形（第 1 个柱形）由于它一定比输入数组里任何一个元素小，它肯定不会出栈，因此栈一定不会为空；
>
> ​		右边的柱形（第 2 个柱形）也正是因为它一定比输入数组里任何一个元素小，它会让所有输入数组里的元素出栈（第 1 个哨兵元素除外）。
>

> **参照题解的个人理解：**
>
> 什么时候可以确定依赖于当前高能够得到的最大宽？
>
> 答： 当遍历时，找到右侧第一个小于栈顶高的，此时即可确定栈顶高的面积。
>
> 右侧已经无法延展，左侧紧邻的栈中元素一定比栈顶的元素小，但只要比栈顶右侧的值大，则可确定新的面积。
>
> 先前压入栈中的值，应当比当前栈顶的值小。
>
> for循环往前走，while循环向后退。

```java
public int largestRectangleArea(int[] heights) {
    int len = heights.length;
    if (len == 0) {
        return 0;
    }

    if (len == 1) {
        return heights[0];
    }

    int res = 0;

    int[] newHeights = new int[len + 2];
    newHeights[0] = 0;
    System.arraycopy(heights, 0, newHeights, 1, len);
    newHeights[len + 1] = 0;
    len += 2;
    heights = newHeights;

    Deque<Integer> stack = new ArrayDeque<>(len);
    // 先放入哨兵，在循环里就不用做非空判断
    stack.addLast(0);

    for (int i = 1; i < len; i++) {
        while (heights[i] < heights[stack.peekLast()]) {
            int curHeight = heights[stack.pollLast()];
            int curWidth = i - stack.peekLast() - 1;
            res = Math.max(res, curHeight * curWidth);
        }
        stack.addLast(i);
    }
    return res;
}
```

以下列出了单调栈的问题，供大家参考。

| 序号 | 题目                          | 题解                                      |
| ---- | ----------------------------- | ----------------------------------------- |
| 1    | 42. 接雨水（困难）            | 暴力解法、优化、双指针、单调栈            |
| 2    | 739. 每日温度（中等)          | 暴力解法 + 单调栈                         |
| 3    | 496. 下一个更大元素 I（简单） | 暴力解法、单调栈                          |
| 4    | 316. 去除重复字母（困难）     | 栈 + 哨兵技巧（Java、C++、Python）        |
| 5    | 901. 股票价格跨度（中等）     | 「力扣」第 901 题：股票价格跨度（单调栈） |
| 6    | 402. 移掉K位数字              |                                           |
| 7    | 581. 最短无序连续子数组       |                                           |

#### [239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)

[「单调队列」数据结构解决滑动窗口问题  题解](https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247488087&idx=1&sn=673aa4e8deb942b951948650928c336e&chksm=9bd7ec5faca06549ba6176540fef04f93c1c9f55b303106688b894a2029e00b8cce1a9ba57a4&scene=21#wechat_redirect)

```java
public class L239_2 {

    //构建单调栈
    public class MonotonicQueue {
        LinkedList<Integer> q = new LinkedList<>();

        public void push(int n) { //当一个较大值过来，形成对前边小的值的压制，从而再后续无法发挥作用
            while (!q.isEmpty() && q.getLast()<n) {
                //比n小的都被踢出
                q.pollLast();
            }
            q.offerLast(n); //尾插
        }

        public Integer max() {  //队列的第一个为最大值
            return q.getFirst();
        }

        public void pop(int n) { //可能n已经被压制的踢出了
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k==0) return nums;
        MonotonicQueue mq = new MonotonicQueue();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            //整个数组过一遍
            if(i < k-1) {
                //填满前两个
                mq.push(nums[i]);
            }else {
                mq.push(nums[i]);
                list.add(mq.max());
                mq.pop(nums[i-k+1]);
            }
        }

        int[] result = new int[nums.length-k+1];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(new L239_2().maxSlidingWindow(nums, k)));
    }
}
```



## 课后作业

#### 用 add first 或 add last 这套新的 API 改写 Deque 的代码



#### 分析 Queue 和 Priority Queue 的源码



#### [622. 设计循环队列](https://leetcode-cn.com/problems/design-circular-queue/)

> 循环队列，头删尾插，这里的容量限定；

- 数组实现

```java
public class L622_shejixunhuanduilie {

    private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;

    public L622_shejixunhuanduilie(int k) {
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
        this.capacity = k;
    }

    //插入一个元素到循环队列
    public boolean enQueue(int value) {
        if (this.count == this.capacity) {
            return false;
        }else {
            queue[(this.headIndex+this.count)%this.capacity] = value;
            count++;
            return true;
        }
    }

    public boolean deQueue() {
        if (this.isEmpty()) return false;
        //不为空时,出队
        this.headIndex = (this.headIndex+1) % this.capacity;
        count--;
        return true;
    }

    public int Front() {
        if (this.count == 0) return -1;
        return this.queue[this.headIndex];
    }

    public int Rear() {
        if (this.count == 0) return -1;
        return this.queue[(this.headIndex+this.count-1)%this.capacity];
    }

    public boolean isEmpty() {
        if (this.count == 0) return true;
        return false;
    }

    public boolean isFull() {
        if (this.capacity == this.count) return true;
        return false;
    }
}
```

- 链表实现

```java
class Node{
    public int value;
    public Node nextNode;
    public Node(int value){
        this.value = value;
        this.nextNode = null;
    }
}

/**
 * @ClassName L622_shejixunhuanduilie
 * @Description
 */
public class L622_shejixunhuanduilie_list {
    //尾插头删
    private Node head,tail;
    private int count;
    private int capacity;

    public L622_shejixunhuanduilie_list(int k) {
        this.capacity = k;
    }

    //插入一个元素到循环队列
    public boolean enQueue(int value) {
        if (this.count == this.capacity) return false;
        Node node = new Node(value);
        if (this.count == 0) {
            head = tail = node;
        } else {
            tail.nextNode = node;
            tail = node;
        }
        this.count++;
        return true;
    }

    public boolean deQueue() {
        if (this.isEmpty()) return false;
        //不为空时,头删
        head = head.nextNode;
        this.count--;
        return true;
    }

    public int Front() {
        if (this.count == 0) return -1;
        return head.value;
    }

    public int Rear() {
        if (this.count == 0) return -1;
        return tail.value;
    }

    public boolean isEmpty() {
       return this.count == 0;
    }

    public boolean isFull() {
        return this.count == this.capacity;
    }
}
```



#### [641. 设计循环双端队列](https://leetcode-cn.com/problems/design-circular-deque/)

```java
public class L641 {

    //用数组比较好
    private int[] deque;
    private int headIndex;
    private int count;
    private int capacity;

//    * Initialize your data structure here. Set the size of the deque to be k.
    public L641(int k) {
        this.capacity = k;
        this.deque = new int[k];
        this.headIndex = 0;
        this.count = 0;
    }

//    * Adds an item at the front of Deque. Return true if the operation is successful.
    public boolean insertFront(int value) {
        if (this.capacity == this.count) return false;
        //能头插
        //头像前移
        headIndex = (headIndex+capacity-1) % capacity;
        deque[headIndex] = value;
        count++;
        return true;
    }

//    * Adds an item at the rear of Deque. Return true if the operation is successful.
    public boolean insertLast(int value) {
        if (this.capacity == this.count) return false;
        //能尾插，先找尾
        int tailIndex = (headIndex+count) % capacity;
        deque[tailIndex] = value;
        count++;
        return true;
    }

//    * Deletes an item from the front of Deque. Return true if the operation is successful.
    public boolean deleteFront() {
        if (this.count == 0) return false;
        //不为空，能头删
        headIndex = (headIndex+1) % capacity;
        count--;
        return true;
    }

//    * Deletes an item from the rear of Deque. Return true if the operation is successful.
    public boolean deleteLast() {
        if (this.count == 0) return false;
        //尾删
        count--;  //注意这里
        return true;
    }

//    * Get the front item from the deque.
    public int getFront() {
        if (this.count == 0) return -1;
        return deque[headIndex];
    }

//    * Get the last item from the deque.
    public int getRear() {
        if (this.count == 0) return -1;
        int tailIndex = (headIndex+count-1) % capacity;  //注意这里
        return deque[tailIndex];
    }

//    * Checks whether the circular deque is empty or not.
    public boolean isEmpty() {
        return this.count == 0;
    }

//    * Checks whether the circular deque is full or not.
    public boolean isFull() {
        return this.count == this.capacity;
    }

}
```

- 链表实现

[链表实现题解](https://leetcode-cn.com/problems/design-circular-deque/solution/java-lian-biao-shi-xian-by-zanyjoker/)

```java

```



#### [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

![image-20210307124431222](img/01-basic/image-20210307124431222.png)

> 单调栈的方式可以继续进行探究





# 4. 哈希表、映射、集合

#### [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)

![image-20210309131236131](img/01-basic/image-20210309131236131.png)

>异位词：指字母相同，但排列不同的字符串。
>
>考虑长度、统计每个字符出现的次数。采用数组、hashmap的方式统计。也可以采用排序后的字符数组进行比对。

```java
public class L242_valid_anagram {

    // 该方法是最通常的解法
    public boolean isAnagram1(String s, String t) {

        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();
        Arrays.sort(sarray);
        Arrays.sort(tarray);
//        return Arrays.equals(sarray, tarray);
        return String.valueOf(sarray).equals(String.valueOf(tarray));  //更快
    }
    
    //使用hash表的思想：以数据方式
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            array[s.charAt(i)-'a']--;
            if (array[s.charAt(i)-'a'] < 0) return false;
        }

        return true;
    }

    //使用hashmap的方式
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)-1);

            if (map.get(ch) < 0) return false;
        }

        return true;
    }
}
```



#### [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)

>分析题：要将异位词进行分组，
>
>暴力解法：通过双重遍历，外层负责覆盖所有的，内层负责判断是否异位以及进行存入。
>
>map的方式：要解决key是什么？value是什么？
>
>在这里key取排序后的字符串，value为list，list中存储每一个字符串。

- 暴力解法

```java
public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) return null;

    List<List<String>> resultList = new LinkedList<>();
    for (int i = 0; i < strs.length; i++) {
        if (strs[i] == null) continue;
        //从头往后判断，如果异位，则添加进去
        List<String> itemList = new LinkedList<>();
        for (int j = strs.length-1; j > i; j--) {
            if (strs[j]!=null && isYiWei(strs[i],strs[j])) {
                //是异位词
                itemList.add(strs[j]);
                strs[j] = null;
            }
        }
        itemList.add(strs[i]);
        resultList.add(itemList);
    }
    return resultList;
}

private boolean isYiWei(String str1, String str2) {
    if (str1.length() != str2.length()) return false;
    char[] chars1 = str1.toCharArray();
    char[] chars2 = str2.toCharArray();
    Arrays.sort(chars1);
    Arrays.sort(chars2);
    return String.valueOf(chars1).equals(String.valueOf(chars2));
}
```

- 使用hash的思想进行存储与输出

```java
public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            //存
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = Arrays.toString(chars);
            List<String> list = map.getOrDefault(str, new ArrayList<>());
            list.add(strs[i]);
            map.put(str, list); 
        }
        return new ArrayList<>(map.values());
}
```



#### [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

> 使用到了Set数据结构，滑动窗口

![image-20210310144904124](img/01-basic/image-20210310144904124.png)

> 采用滑动窗口的方式，左右双指针，右指针探索，并始终保持Set集合中的字符不重复;
>
> 当出现重复时,左侧的字符从set中移除,**右侧仍旧可以继续探索.**

- 滑动窗口法，使用set

```java
public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int rightIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            //右下标后移
            while (rightIndex < s.length() && !set.contains(chars[rightIndex])) {
                set.add(chars[rightIndex]);
                rightIndex++;
            }
            //右下边移到了重复的
            maxLength = Math.max(maxLength, set.size());  //rightIndex-i+1

            //左下标+1，并且移除chars[i]
            set.remove(chars[i]);
        }
        return maxLength;
}
```

- 滑动窗口法，使用map

```java
public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
        
}
```





# 5. 树、二叉树、二叉搜索树

#### [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

> 中序遍历：左根右

- 递归方式 （省略，太简单）

- 迭代方式: 显示的维护一个栈

```java
//采用维护一个显示栈的方式来中序遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;

        Deque<TreeNode> stack = new ArrayDeque<>();

        //构建循环   左 根 右  =》  压栈顺序   根 读左， 读根  再到右侧
        while (root != null || !stack.isEmpty()) {
            //要一直走到最后
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            //此时root必定为空，则root.right也为空，如此即可保证
            root = stack.pop();
            //走到的最左边的子节点
            resultList.add(root.val);
            root = root.right;

        }
        return resultList;
}
```

- Morris中序遍历：时间复杂度O(n),空间复杂度O(1）

> 左根右，核心思想是先找到当前根节点的左子树的最右侧的节点，让该节点连接到其后驱即根节点。

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                
                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
```



#### [144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

- 递归版的前序遍历（省略，太简单）

- 使用显示栈的方式进行遍历

```java
public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        //根左右
        while (!stack.isEmpty()) {

            TreeNode treeNode = stack.pop();
            if (treeNode.val != null) {
                resultList.add(treeNode.val);
            }

            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }

            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return resultList;
}
```



#### [145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

- 迭代方式

> 特别注意 如果要是想输出上一层的，一定是通过栈pop出去的，但要防止重复入左或者入右，防止入左可以通过将root置0，防止入右可以通过记录先前已经访问过的右节点，来避免。

```java
//迭代的方式： 左 右  根
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            //根  右   左进行压栈
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            // root此时为空
            root = stack.pop();  //此时只知其左没有，不知其右
            //resultList.add(root.val);

            if (root.right == null || root.right == prev) {
                //右节点没有了
                resultList.add(root.val);
                prev = root;
                root = null;
            } else {
                //右节点有
                stack.push(root);
                root = root.right;  //但要防止之后再回到该右分支，使用prev记录分离点
            }
        }
        
        return resultList;
}
```

- 使用两个栈进行(很好理解)  也可用于先序遍历

```java
public List<Integer> postorderTraversal2(TreeNode root) {
        //非递归方式
        //定义两个栈s1,s2，将root压入s1
        //从s1出栈，并将该节点压入s2，接着将节点的左右节点压入s1
        //重复上一步操作，直到s1为空，依此从s2中出栈即可
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        TreeNode cur = root;
        while(!s1.empty()) {
            TreeNode node = s1.pop();
            if(node.left != null) {
                s1.push(node.left);
            }
            if(node.right != null) {
                s1.push(node.right);
            }
            s2.push(node);
        }
        while(!s2.empty()) {
            TreeNode tmp = s2.pop();
            list.add(tmp.val);
        }
        return list;
}
```



#### [102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

> 注意控制好何时进行出队，以及什么时候添加到itemList中去，考虑怎么限定循环次数

- **广度优先进行迭代**

```java
public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        if (root == null) return resultList;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> itemList = new LinkedList<>();

            int currentLength = queue.size(); //限定每次循环循环次数
            
            for (int i = 1; i <= currentLength; i++) {
                //出根，添加到itemList中
                TreeNode node = queue.poll();  //
                itemList.add(node.val);
                //进左
                if (node.left != null) {
                    queue.offer(node.left);
                }

                //进右
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            resultList.add(itemList);

        }
        return resultList;
}
```

- 深度优先搜索采用递归的方式

```java
public List<List<Integer>> levelOrder1(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        //用来存放最终结果
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(1,root,res);
        return res;
    }

    void dfs(int index,TreeNode root, List<List<Integer>> res) {
        //假设res是[ [1],[2,3] ]， index是3，就再插入一个空list放到res中
        if(res.size()<index) {
            res.add(new ArrayList<Integer>());
        }
        //将当前节点的值加入到res中，index代表当前层，假设index是3，节点值是99
        //res是[ [1],[2,3] [4] ]，加入后res就变为 [ [1],[2,3] [4,99] ]
        res.get(index-1).add(root.val);
        //递归的处理左子树，右子树，同时将层数index+1
        if(root.left!=null) {
            dfs(index+1, root.left, res);
        }
        if(root.right!=null) {
            dfs(index+1, root.right, res);
        }
}
```





#### [107. 二叉树的层序遍历 II](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)



#### [589. N 叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)



- 递归

```java
public List<Integer> preorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;

        preTraverse(root, resultList);
        return resultList;

    }

    private void preTraverse(Node root, List<Integer> resultList) {
        if (root == null) return;
        //根
        resultList.add(root.val);
        //下一层
        for(Node node: root.children) {
            preTraverse(node, resultList);
        }
}
```

- 迭代（在List遍历时，最好使用foreach来进行遍历，不会产生越界问题）

```java
public List<Integer> preorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        if(root == null) return resultList;

        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            int curLength = stack.size();
            Node node = stack.pop();
            resultList.add(node.val);
            //将其child反序入栈
            Collections.reverse(node.children);
            // for(int i=0; i < curLength; i++) {  //这种方式会越界
            //     stack.push(node.children.get(i));
            // }
            for(Node child : node.children) {
                stack.push(child);
            }
        }
        return resultList;
}
```



#### [590. N 叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)

```java
public List<Integer> postorder(Node root) {
        LinkedList<Integer> resultList = new LinkedList<>();  //只有LinkedList才可以,才实现了addFirst
        if(root == null) return resultList;

        Deque<Node> stack = new LinkedList<>();
        stack.push(root);

        //
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            //头插
            resultList.addFirst(node.val);

            for(Node child: node.children) {
                //从左到右入栈，则出栈顺序为从右到左
                stack.push(child);
            }
        }
        return resultList;
}
```



#### [429. N 叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

```java
public List<Integer> preorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        if(root == null) return resultList;

        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int currentSize = queue.size();
            for(int i=0; i<currentSize; i++) {
                Node node = queue.poll();
                resultList.add(node.val);
                for(Node child: node.children) {
                    queue.offer(child);
                }
            }
        }
        return resultList;
}
```





# 6. 递归、泛型递归、树的递归

## 实战题目





· https://leetcode-cn.com/problems/generate-parentheses/



· https://leetcode-cn.com/problems/invert-binary-tree/description/



· https://leetcode-cn.com/problems/validate-binary-search-tree



· https://leetcode-cn.com/problems/maximum-depth-of-binary-tree



· https://leetcode-cn.com/problems/minimum-depth-of-binary-tree



· https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/





## 课后作业

· https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

· https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

· https://leetcode-cn.com/problems/combinations/

· https://leetcode-cn.com/problems/permutations/

· https://leetcode-cn.com/problems/permutations-ii/





# 7. 分治、回溯

## 预习题目

· https://leetcode-cn.com/problems/powx-n/



· https://leetcode-cn.com/problems/subsets/



· [括号生成问题](https://leetcode-cn.com/problems/generate-parentheses/)

## 实战题目

· [https://leetcode-cn.com/problems/majority-element/description/ ](https://leetcode-cn.com/problems/majority-element/description/)（简单、但是高频）



· https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

· https://leetcode-cn.com/problems/n-queens/





# 8. 深度优先搜索、广度优先搜索

## 实战题目

· [https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description](#/description)

· [https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description](#/description)

· [https://leetcode-cn.com/problems/generate-parentheses/#/description](#/description)

· [https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description](#/description)

## 课后作业

· https://leetcode-cn.com/problems/word-ladder/description/

· https://leetcode-cn.com/problems/word-ladder-ii/description/

· https://leetcode-cn.com/problems/number-of-islands/

· https://leetcode-cn.com/problems/minesweeper/description/





# 9. 滑动窗口

https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/



[3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)



[30. 串联所有单词的子串](https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/)



[76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)

[159. 至多包含两个不同字符的最长子串](https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/)

[209. 长度最小的子数组](https://leetcode-cn.com/problems/minimum-size-subarray-sum/)

[239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)

[567. 字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/)

[632. 最小区间](https://leetcode-cn.com/problems/smallest-range/)

[727. 最小窗口子序列](https://leetcode-cn.com/problems/minimum-window-subsequence/)





