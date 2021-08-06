package leetcode;

import java.util.*;

/**
 * @ClassName L155_1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/17 21:23
 * @Version 1.0
 **/
public class L155_1 {

    private Deque<AbstractMap.SimpleEntry<Integer,Integer>> deque = new LinkedList();


    public L155_1() {
    }

    public void push(int val) {
        if(deque.size() == 0) {
            deque.push(new AbstractMap.SimpleEntry<Integer,Integer>(val,val));
        } else {
            deque.push(new AbstractMap.SimpleEntry<Integer,Integer>(val,Math.min(deque.peek().getValue(), val)));
        }
    }

    public void pop() {
        deque.pop();
    }

    public int top() {
        return deque.peek().getKey();
    }

    public int getMin() {
        return deque.peek().getValue();
    }

}
