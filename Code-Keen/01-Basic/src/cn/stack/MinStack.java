package cn.stack;

import java.util.Stack;

/**
 * @ClassName MinStack
 * @Description
 */

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            if (x <= minStack.peek()) {  //这里存在一个便捷问题，是<还是<=
                minStack.push(x);  //若取<,则在pop时，pop==min，对minStack需要pop，则min与stack会出现不一致情况。
            }
        }else {
            minStack.push(x);
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
