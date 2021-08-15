package interview.beike;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public long[] FarmerNN (int n, long m) {
        // write code here
        long[] result = new long[n];

        //if(n==1) {
        //    result[0] = m;
        //    return result;
        //}
        //if(n==2) {
        //    result[0] = m/2+m%2;
        //    result[1] = m/2;
        //    return result;
        //}


        //while()


        return result;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Main1().FarmerNN(4,6)));
        System.out.println(Arrays.toString(new Main1().FarmerNN(3,10)));
        //System.out.println(Arrays.toString(new Main1().FarmerNN(2,5)));
        //System.out.println(Arrays.toString(new Main1().FarmerNN(2,6)));
    }
}
