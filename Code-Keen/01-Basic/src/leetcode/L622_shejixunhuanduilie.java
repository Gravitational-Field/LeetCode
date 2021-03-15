package leetcode;

/**
 * @ClassName L622_shejixunhuanduilie
 * @Description
 */
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

    public static void main(String[] args) {
        L622_shejixunhuanduilie circularQueue = new L622_shejixunhuanduilie(3); // 设置长度为 3
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
