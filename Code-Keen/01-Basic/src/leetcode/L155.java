package leetcode;

import java.util.*;

/**
 * @ClassName L155
 * @Description
 */
public class L155 {
    Deque<Integer> deque = new LinkedList<>();
    /*private Deque<SEntry<Integer, Integer>> deque = new LinkedList<>();

    *//** initialize your data structure here. *//*
    public L155() {
    }

    public class SEntry<K,V> implements Map.Entry<K,V> {
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
    }*/


    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public L155() {
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
            if (x <= minStack.peek()) {  //注意这里是相等，为了保证pop的一致性
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
