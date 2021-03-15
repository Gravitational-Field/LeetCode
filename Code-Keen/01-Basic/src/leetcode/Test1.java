package leetcode;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * @ClassName Test1
 * @Description
 */
public class Test1 {

    /**
     * 测试Deque类
     */
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

    /**
     * 测试Entry
     */
    @Test
    public void testEntry() {
        /**
         * 自己创建一个Entry的实现类
         */
        class SEntry<K,V> implements Map.Entry<K,V> {
            private K key;
            private V value;

            public SEntry(){}

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

            @Override
            public String toString() {
                return "SEntry{" +
                        "key=" + key +
                        ", value=" + value +
                        '}';
            }
        }

        SEntry<Integer,Integer> entry = new SEntry<>(10,15);
        System.out.println(entry);
        System.out.println(entry.getKey());

    }

    /**
     * 测试优先级队列
     */
    @Test
    public void testPriorityQueue() {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?o2[0]-o1[0]:o2[1]-o1[1];
            }
        });
        int[] o1 = {5,8};
        int[] o2 = {10,3};
        priorityQueue.add(o1);
        priorityQueue.add(o2);
        System.out.println(priorityQueue.toArray()[0]);

    }

    @Test
    public void testNull() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("mysql:jdbc://localhost:3306/ssm", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String catalog = conn.getCatalog();

    }

    /**
     * 测试List的读取
     * 结论： 可以读取，但在使用迭代时（如N叉树的遍历），最好还是使用foreach来进行迭代，
     * 如果需要反向迭代，使用Collections.reverse()翻转后，再进行迭代
     */
    @Test
    public void testListReverseIndex() {
//        Integer[] array = {11,22,33,44,55,66,77,88,99};
        List<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"   ");  // aaa   bbb   ccc
        }
        list.add("ddd");
        System.out.println();
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i)+"   ");  // ddd   ccc   bbb   aaa
        }
        System.out.println();
        Collections.reverse(list);
        for(String str: list) {
            System.out.print(str+"  ");  //reverse之前： aaa   bbb   ccc   ddd  reverse之后：  ddd   ccc   bbb   aaa
        }
        System.out.println();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+"  ");  //reverse之前： aaa  bbb  ccc  ddd  reverse之后： ddd ccc bbb  aaa
        }

    }

    /**
     * String与StringBuilder的使用
     */
    @Test
    public void testStringBuider(){
        StringBuilder sb = new StringBuilder();
        sb.append("abcde");
        sb.deleteCharAt(3);
        System.out.println(sb.toString());
        String str = "hello";
        str = str + " world";
        System.out.println(str);

    }




}
