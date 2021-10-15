import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName TopK
 * @Description
 */
public class TopK {



    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7,8,9,10};
        int k = 3;
        System.out.println(Arrays.toString(getTopK(num,k)));

    }

    private static int[] getTopK(int[] num, int k) {
        int[] res = new int[k];
//        LinkedList<Integer> list = new LinkedList<Integer>(k);
        int curMin = Integer.MAX_VALUE;
        //Deque<Integer> stack = new ArrayDeque<>(); //最小值栈

        for (int i = 0; i < k; i++) {
//            res[i] = num[i];
            if (num[i] < curMin) {
                curMin = num[i];
                //stack.push(curMin);
            }
//            list.add(num[i]);
        }

        for (int i = k; i < num.length; i++) {
            //进行排序
            //每次找到最小的，然后移除
//            if ()




        }

        //list 转 res
        return res;
    }
}


/*class PriorityQueue{

    int[] sortedArr = new int[3];



}*/
