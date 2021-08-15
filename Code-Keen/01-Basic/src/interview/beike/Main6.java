package interview.beike;

import java.util.Arrays;

public class Main6 {

    public long[] FarmerNN (int n, long m) {
        long[] result = new long[n];
        long turns = m/(n-1);
        long more = m%(n-1);

        result[0]= turns%2 == 1? turns/2+1:turns/2;
        result[n-1] = turns/2;

        for (int i = 1; i < n-1; i++) {
            result[i] = turns;
        }

        if(turns % 2 ==1) {
            for (int i = 0; i < more; i++) {
                result[n-1-i]++;
            }
        } else {
            for (int i = 0; i < more; i++) {
                result[i]++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Main6().FarmerNN(4,6)));
        System.out.println(Arrays.toString(new Main6().FarmerNN(3,10)));
        System.out.println(Arrays.toString(new Main6().FarmerNN(2,5)));
        System.out.println(Arrays.toString(new Main6().FarmerNN(2,6)));
    }
}
