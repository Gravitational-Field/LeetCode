package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName L860
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/4/15 21:17
 * @Version 1.0
 **/
public class L860 {

    Map<Integer, Integer> map = new HashMap<>();

    public boolean lemonadeChange(int[] bills) {
        if(bills == null || bills.length == 0) {
            return true;
        }
        map.put(5, 0);
        map.put(10, 0);
        map.put(20, 0);

        //模拟付账
        for (int i = 0; i < bills.length; i++) {
            int curPrice = bills[i];
            int returnCount = 0;


            map.put(curPrice, map.get(curPrice)+1);
            if(curPrice == 5) continue;
            if(curPrice == 10) {
                if(map.get(5) == 0) {
                    return false;
                }
                map.put(5, map.get(5)-1);
            } else { //curPrice == 20
                if(map.get(10) > 0 && map.get(5) > 0) { // 1.第一种能通过的情况
                    map.put(10,map.get(10)-1);
                    map.put(5,map.get(5)-1);
                } else if(map.get(10) == 0 && map.get(5) >= 3) { //2. 第二种能通过的情况
                    map.put(5,map.get(5)-3);
                } else { // 通不过的情况
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        int[] bills = {5,5,10,5,20,5,5,5,5,5,20,5,10,5,5,5,5,20,20,5};
        int[] bills = {5,5,5,10,20};
        System.out.println(new L860().lemonadeChange(bills));

    }
}
