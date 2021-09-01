package leetcode;

/**
 * @ClassName L622_1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/25 10:20
 * @Version 1.0
 **/
public class L622_1 {
    int[] arr;
    int headIndex;
    int tailIndex;
    int k; //容量
    int size;

    L622_1(int k) { //MyCircularQueue
        arr = new int[k];
        this.k = k;
        headIndex = 0;
        tailIndex = 0; //最后元素的位置？   还是  下一个插入位置？   甚至可以不要这项，通过headIndex+size 进行计算
        size = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        size++;
        arr[(tailIndex)%k] = value;
        tailIndex = (tailIndex+1)%k;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        size--;
        headIndex = (headIndex+1)%k;

        return true;
    }

    public int Front() {
        if(size == 0) {
            return -1;
        }
        return arr[headIndex];
    }

    public int Rear() {
        if(size == 0) {
            return -1;
        }
        return arr[(tailIndex+k-1)%k];
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(size == k) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        L622_1 obj = new L622_1(3);
        System.out.println(obj.enQueue(1));
        System.out.println(obj.enQueue(2));
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
        System.out.println(obj.isFull());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());


    }
}
