package interview.xiaomi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName Mi1
 * @Description
 */
public class Mi1 {

    public static void main(String[] args) {
        int[] arr = {5,4,2,9,7,1,10,100,200,8};
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int k = 3;
        pq.offer(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            if(pq.peek()>arr[i]){
                pq.offer(arr[i]);
            }

            if(pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> list = new ArrayList<>(pq);

        for(Integer i:list) {
            System.out.print(i+" ");
        }
    }


}
