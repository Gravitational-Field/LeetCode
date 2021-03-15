package leetcode;

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

    public static void main(String[] args) {
        L622_shejixunhuanduilie_list circularQueue = new L622_shejixunhuanduilie_list(3); // 设置长度为 3
        circularQueue.enQueue(1);  // 返回 true
        circularQueue.enQueue(2); // 返回 true
        circularQueue.enQueue(3); // 返回 true
        circularQueue.enQueue(4); // 返回 false，队列已满
        circularQueue.Rear();  // 返回 3
        circularQueue.isFull();  // 返回 true
        circularQueue.deQueue();  // 返回 true
        circularQueue.enQueue(4);  // 返回 true
        circularQueue.Rear(); // 返回 4

    }
}
