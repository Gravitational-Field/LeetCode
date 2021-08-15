package interview.beike;

import java.util.Arrays;

public class Main5 {

    public long[] FarmerNN (int n, long m) {
        long[] result = new long[n];

        if(n==1) {
            result[0] = m;
            return result;
        }
        if(n==2) {
            result[0] = m/2+m%2;
            result[1] = m/2;
            return result;
        }
        int i = 0;
        long count = 0;
        boolean flag = true; //正向
        //while (count++ != m) {
        //    //System.out.println(count);
        //    if
        //    System.out.println(i);
        //    result[i%n] = result[i%n]+1;
        //    if(flag) {
        //        i++;
        //    } else{
        //        i--;
        //    }
        //
        //
        //    //什么时候切换为flag = !flag?
        //    //System.out.println(i%n);
        //
        //}
        System.out.println("======================================");
        return result;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Main5().FarmerNN(4,6)));
        System.out.println(Arrays.toString(new Main5().FarmerNN(3,10)));
        System.out.println(Arrays.toString(new Main5().FarmerNN(2,5)));
        System.out.println(Arrays.toString(new Main5().FarmerNN(2,6)));
        //[1, 2, 2, 1]
        //[3, 5, 2]
        //[3, 2]
        //[3, 3]
    }
}
