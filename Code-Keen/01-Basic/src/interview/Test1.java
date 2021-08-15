package interview;

import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Long mod = 1000000007l;
        while (input.hasNext()) {
            Long n = input.nextLong();  //n个不同的字符
            Long l = input.nextLong();  //长度最长为l
            if (n == 0 && l == 0) {
                break;
            }
            Long sum = 0l;
            Long k = n;
            while(l>0){
                sum+=k;
                sum%=mod;
                k=k*n%mod;
                l--;
            }
            System.out.println(sum);
        }
    }
}
