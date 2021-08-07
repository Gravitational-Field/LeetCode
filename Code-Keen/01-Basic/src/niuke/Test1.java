package niuke;

/**
 * @ClassName Test1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/29 19:42
 * @Version 1.0
 **/
public class Test1 {

    public int getSize (long n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        // write code here
        for(int i = 1; i<Math.sqrt(n); i++) {
            if(Math.pow(2,i-1)<=n && Math.pow(2,i)>n) {
                return i;
            }
        }
        return -1;
    }
}
