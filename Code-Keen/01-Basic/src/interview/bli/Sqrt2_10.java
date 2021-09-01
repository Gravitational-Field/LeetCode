package interview.bli;

/**
 * @ClassName Sqrt2_10
 * @Description: 二分查找典型示例
 * @Author Keen
 * @DATE 2021/9/1 11:22
 * @Version 1.0
 **/
public class Sqrt2_10 {

    public static void main(String[] args) {
        //计算根号2
        System.out.println(sqrt(2,0.0000000001,0,2));
        System.out.printf("%.10f",sqrt(2,0.0000000001,0,2));

    }

    //迭代
    static double mySqrt(int num, double threshold) {
        double left = 0, right = num;
        while (right - left > threshold) {
            double mid = left + (right-left)/2;
            if(mid*mid == num) return mid;
            else if(mid*mid < num) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    //递归
    static double sqrt(int num, double threshold, double left, double right) {
        double mid = left + (right-left)/2;
        if(mid*mid == num) {
            return mid;
        }
        if(right-left<threshold) {
            return left;
        }
        if(mid*mid < num ) {
            return sqrt(num,threshold, mid, right);
        } else {
            return sqrt(num,threshold, left, mid);
        }
    }
}
