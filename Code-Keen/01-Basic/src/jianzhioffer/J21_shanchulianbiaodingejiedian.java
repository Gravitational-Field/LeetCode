package jianzhioffer;

import cn.linkedlist.ListNode;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ClassName J21_shanchulianbiaodingejiedian
 * @Description: 删除链表的第n个节点
 * @Author Keen
 * @DATE 2021/8/7 11:14
 * @Version 1.0
 **/
public class J21_shanchulianbiaodingejiedian {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n<=0) return head;

        ListNode realHead = new ListNode();
        realHead.next = head;

        //计算其数量
        int count = 0;
        while (head != null) {
            count++;
            head=head.next;
        }

        int preIndex = count-n;
        head = realHead;
        while (preIndex != 0) {
            preIndex--;
            head = head.next;
        }
        head.next = head.next.next;

        return realHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();



    }

}
