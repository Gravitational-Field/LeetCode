package interview.baidu;

import java.util.*;

/**
 * @ClassName Test3
 * @Description 文件中 ip统计
 */
public class Test3 {
    public PriorityQueue<Object[]> pq = new PriorityQueue<Object[]>(new Comparator<Object[]>() {
        @Override
        public int compare(Object[] o1, Object[] o2) {
            return Integer.valueOf(o2[1].toString() )- Integer.valueOf(o1[1].toString());
        }
    });

    //访问次数最多的三个ip
    public List<String> getMaxCount(String[] strArr) {
        ArrayList<String> list = new ArrayList<>();
        //{ip,count,time}

        //解析IP
        for (String s : strArr) {
            //迭代解析，并存入优先级队列pq中

        }
        

        return list;
    }


    public static void main(String[] args) {
        String[] strArr = {"word=xxx ip=10.10.10.10 time=1010","word=xxx ip=10.10.10.11 time=1010"};


    }
}
