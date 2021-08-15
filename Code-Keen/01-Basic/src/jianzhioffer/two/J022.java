package jianzhioffer.two;

import cn.linkedlist.ListNode;

/**
 * @ClassName J022
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/9 8:15
 * @Version 1.0
 **/
public class J022 {

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode fast=head,slow=head;
        while(fast.next != null && fast.next.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        if(fast.next == null || fast.next.next == null) {
            return null;
        }
        slow = head;
        while (fast!=slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
