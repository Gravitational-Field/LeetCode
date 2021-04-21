package leetcode;

/**
 * @ClassName L367
 * @Description: 判断是否是完全平方数
 * @Author Keen
 * @DATE 2021/4/19 15:26
 * @Version 1.0
 **/
public class L367 {

    public boolean isPerfectSquare(int num) {
        if(num == 1) {
            return true;
        }
        int left = 1;
        int right = num/2;
        while (left <= right) {
            long mid = left + (right-left)/2;
            if(mid*mid == num) {
                return true;
            } else if(mid*mid > num) {
                right = (int)mid - 1;
            } else if(mid*mid < num) {
                left = (int)mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int num = 808201;
        System.out.println(new L367().isPerfectSquare(num));
        //System.out.println(Integer.MAX_VALUE);
    }
}
