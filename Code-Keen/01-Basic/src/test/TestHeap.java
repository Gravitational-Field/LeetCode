package test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * @ClassName TestHeap
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/15 14:51
 * @Version 1.0
 **/
public class TestHeap {


    public static void main(String[] args) {

        PriorityQueue<AbstractMap.SimpleEntry<String, int[]>> objects = new PriorityQueue<AbstractMap.SimpleEntry<String, int[]>>(
                (o1,o2)->(o2.getKey()!=o1.getKey()?o2.getValue()[0]-o1.getValue()[0]:o2.getValue()[1]-o1.getValue()[1]));

        PriorityQueue<AbstractMap.SimpleEntry<String, int[]>> pq1 = new PriorityQueue<AbstractMap.SimpleEntry<String, int[]>>(new Comparator<Map.Entry<String, int[]>>() {
            @Override
            public int compare(Map.Entry<String, int[]> o1, Map.Entry<String, int[]> o2) {

                if(o1.getKey().equals(o2.getKey())) {
                    return 0;
                }
                for (int i = 0; i < o2.getValue().length; i++) {
                    if(o2.getValue()[i]- o1.getValue()[i] <0) {
                        return -1;
                    } else if(o2.getValue()[i]- o1.getValue()[i] >0) {
                        return 1;
                    }
                }
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        });




        AbstractMap.SimpleEntry<String, int[]> e1 = new AbstractMap.SimpleEntry("a", new int[]{1,2,3});
        AbstractMap.SimpleEntry<String, int[]> e2 = new AbstractMap.SimpleEntry("a", new int[]{1,1,4});
        AbstractMap.SimpleEntry<String, int[]> e3 = new AbstractMap.SimpleEntry("b", new int[]{4,2,3});
        AbstractMap.SimpleEntry<String, int[]> e4 = new AbstractMap.SimpleEntry("c", new int[]{4,1,3});


        //Map<String, int[]> map1 = new HashMap<>();
        //pq1.add(map1.);
        //map1.putIfAbsent();
        //e1.getKey()
        pq1.offer(e1);
        pq1.offer(e2);
        pq1.offer(e3);
        //pq1.offer(e4);
        AbstractMap.SimpleEntry<String, int[]> remove = pq1.element();
        System.out.println(remove.getKey()+" : "+remove.getValue()[0]+" : "+remove.getValue()[1]+" : "+remove.getValue()[2]);

        //boolean remove = pq1.remove(new AbstractMap.SimpleEntry("a", e1.getValue()));
        //System.out.println(remove.getKey()+" : "+remove.getValue()[0]+" : "+remove.getValue()[1]+" : "+remove.getValue()[2]);
        //System.out.println(remove);
        System.out.println("==================");
        for (AbstractMap.SimpleEntry<String, int[]> entry : pq1) {
            System.out.println(entry.getKey()+" : "+entry.getValue()[0]+" : "+entry.getValue()[1]+" : "+entry.getValue()[2]);
        }


    }
}
