package test.collection;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName TestPriorityQueue
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/10 15:37
 * @Version 1.0
 **/
public class TestPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] pair1,int[] pair2){
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0]:pair1[1] - pair2[1];  //不相同时，按照第0位，从大到小；相同时，按照第1位，从小到大
            }
        });
        pq.offer(new int[]{5,0});
        pq.offer(new int[]{5,1});
        pq.offer(new int[]{5,2});
        //new int[]{nums[i],i}

        PriorityQueue<AbstractMap.SimpleEntry<Integer,Integer>> pq1 = new PriorityQueue<>(new Comparator<AbstractMap.SimpleEntry<Integer, Integer>>() {
            @Override
            public int compare(AbstractMap.SimpleEntry<Integer, Integer> o1, AbstractMap.SimpleEntry<Integer, Integer> o2) {
                return o1.getKey()!=o2.getKey()? o2.getKey() - o1.getKey(): o1.getValue() - o2.getValue();
            }
        });

    }
}
