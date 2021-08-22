package interview.tx;

/**
 * @ClassName Test1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/22 19:49
 * @Version 1.0
 **/
public class Test1 {

    public class ListNode {
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
                res[val%m] = new ListNode(val%m);
            } else { //不为空
                ListNode temp= res[val%m];
                while(temp.next != null) temp = temp.next;
                temp.next = new ListNode(val%m);;
            }
            a = a.next;
        }


        return res;  //0.1
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
