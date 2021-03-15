package leetcode;

import java.util.*;

/**
 * @ClassName Solution
 * @Description
 */
public class Solution {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        HashSet<Integer[]> set = new HashSet<>(); //输入去重
        HashMap<Integer, List<Integer>> map1 = new HashMap<>(); //目标， 能联系到目标的列表
//        HashMap<Integer, List<Integer>> map2 = new HashMap<>(); // 情况map
//
//        ArrayList<Integer> arrayList = new ArrayList(); //下标为
        int n,m=0;
        n = sc.nextInt();
        m = sc.nextInt();

        Integer[] array = new Integer[n]; //n大小的数组   b为下标，a为目的地
        /*System.out.println(n);
        System.out.println(m);*/
        for (int i = 0; i<m; i++) {
            int a,b=0;
            a = sc.nextInt();
            b = sc.nextInt();
            map1.getOrDefault(b,new ArrayList<>()).add(a);
        }
        System.out.println("=============================");
        int q = sc.nextInt();
        int min = 0;
        for (int i = 0; i < q; i++) {
            int niuniu,niumei=0;
            niuniu = sc.nextInt();
            niumei = sc.nextInt();
            System.out.println(find(map1, niuniu, niumei));
        }

        System.out.println("=============================");
        for (Integer key:map1.keySet()) {
            System.out.println(key + " " + map1.get(key));
        }
    }

    private static int find(HashMap<Integer, List<Integer>> map, int niuniu, int niumei) {
        if (map.size() <= 1) return -1; //找不到
        //最小
        int min = 0;
        for (Integer pre: map.get(niumei)) {
            if (pre == niuniu) return min+1;
            //能找到牛妹的
            min = find(map,niuniu,niumei) == 0?0:0;
        }
        return min == 0? 0:min;
    }

}
