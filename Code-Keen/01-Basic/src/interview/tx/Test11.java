package interview.tx;

/**
 * @ClassName Test1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/22 19:49
 * @Version 1.0
 **/
public class Test11 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode[] solve (int m, ListNode a) {
        ListNode[] res = new ListNode[m];
        while (a != null) {
            int val = a.val;
            if(res[val%m] == null) {
                res[val%m] = new ListNode(val);
            } else { //不为空
                ListNode temp= res[val%m];
                while(temp.next != null) temp = temp.next;
                temp.next = new ListNode(val);;
            }
            a = a.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode temp = a;
        a.next = new ListNode(1);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(11);
        a.next.next.next.next.next.next = new ListNode(16);

        System.out.println(new Test11().solve(5, a));
    }
}


/*class Solution:
        def solve(self , m , a ):
        # write code here
        res = [set() for _ in range(m)]
        while a:
        res[a.val%m].add(a.val)
        a = a.next
        return res*/
