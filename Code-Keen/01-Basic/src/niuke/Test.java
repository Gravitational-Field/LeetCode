package niuke;

import java.util.*;

/**
 * @ClassName Test
 * @Description: 全排列
 * @Author Keen
 * @DATE 2021/7/31 20:02
 * @Version 1.0
 **/
public class Test {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            String[] qiu = new String[n];

            //qiu = ;
            for (int i = 0; i < qiu.length; i++) {
                qiu[i] = in.next();  //1 4 3
            }

            System.out.println(Arrays.toString(qiu));

            //输入进去了，从n个球中抽m个
            ArrayList<String> strArray = new ArrayList<>();  //所有的排列
            dfs(qiu, strArray,0, m);

            /*for (int i = 0; i < res.size(); i++) {
                List<Integer> integers = res.get(i);
                for (int j = 0; j < integers.size(); j++) {
                    //System.out.print(Arrays.toString(integers.get(j)));
                    System.out.println();
                }
                System.out.println();
            }*/


            /*3 3 1 2
            1 4 3*/
        }
    }

    static List<String> res = new ArrayList<>();
    static Deque<String> deque = new LinkedList<>();


    private static void dfs(String[] nums,ArrayList<String> strArray, int index, int m) {
        if(index == m) {
            //res.add(new ArrayList<>(deque));
            return;
        }
        //考虑选择当前位置
        //deque.push("");
        //dfs(nums, index+1, m);
        //deque.pop(); //回退一步，考虑不选择当前位置
        //dfs(nums, index+1, m);

    }


}
