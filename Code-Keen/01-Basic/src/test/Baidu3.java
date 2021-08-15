package test;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName Baidu3
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/11 16:23
 * @Version 1.0
 **/
public class Baidu3 {
    //{ip:[count,time]}
    PriorityQueue<AbstractMap.SimpleEntry<String,int[]>> pq = new PriorityQueue<AbstractMap.SimpleEntry<String,int[]>>(new Comparator<AbstractMap.SimpleEntry<String, int[]>>() {
        @Override
        public int compare(AbstractMap.SimpleEntry<String, int[]> o1, AbstractMap.SimpleEntry<String, int[]> o2) {
            //count从上到下，相同时time从上到下
            return o2.getValue()[0]!=o1.getValue()[0]?o2.getValue()[0]-o1.getValue()[0]:o2.getValue()[1]-o1.getValue()[1];
        }


    });

    //解析数组
    public void parseStrArr(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            String ip = strArr[i].substring(12,23);
            String time = strArr[i].substring(29,33);
            System.out.println("ip: " + ip +"  time: "+time);
            if(pq.contains(new AbstractMap.SimpleEntry<>(ip, null))) System.out.println("hahahaha");
            //pq.offer(new )

        }
    }




    public List<String> getThreeTop() {

        return null;
    }

    public static void main(String[] args) {
        String[] strArr = {"word=xxx ip=10.10.10.10 time=1010","word=xxx ip=10.10.10.10 time=1010"};
        new Baidu3().parseStrArr(strArr);
    }
}
