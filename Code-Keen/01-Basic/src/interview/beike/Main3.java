package interview.beike;

import java.util.Scanner;

public class Main3 {

    public long section (int[] a, int t) {
        // write code here
        int n = a.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if((a[i]^a[j])==t) {
                    result+=(n-j)+1;
                }
            }
        }
        System.out.println("总个数："+n*(n-1)/2);
        return n*(n-1)/2-result;
    }

    private long counter(int start, int end) {
        return (long)(1+end-start)*(end-start)/2;
    }

    public static void main(String[] args) {

        //Scanner cin = new Scanner(System.in);
        //int a, b;
        //while(cin.hasNextInt())
        //{
        //    a = cin.nextInt();
        //    b = cin.nextInt();
        //    System.out.println(a + b);
        //}
        int[] arr = {2,3,4};
        System.out.println(new Main3().section(arr,6)); //2
         int[] arr1 = {2,3,8};
        System.out.println(new Main3().section(arr,6)); //1

    }
}
