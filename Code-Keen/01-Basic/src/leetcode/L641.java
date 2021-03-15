package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/*class Node {
    public int value;
    public Node nextNode;

    public Node(int value) {
        this.value = value;
    }
}*/

/**
 * @ClassName L641
 * @Description 设计循环双端队列
 */
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
        count--;
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
        int tailIndex = (headIndex+count-1) % capacity;
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

    public static void main(String[] args) {
        L641 circularDeque = new L641(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));
        System.out.println(circularDeque.insertLast(2));
        System.out.println(circularDeque.insertFront(3));
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getFront());

    }
}
