import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int a, b;
        while(cin.hasNextInt())
        {
            a = cin.nextInt();
            b = cin.nextInt();
            System.out.println(a + b);
            int[][] arr = new int[3][4];
            for (int i = 0; i < arr.length; i++) {
                Arrays.fill(arr,Integer.valueOf(i));
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
        }

    }
}
