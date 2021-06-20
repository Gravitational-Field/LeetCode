package mianshi;

/**
 * @ClassName Tonghuashun
 * @Description
 */
public class Tonghuashun {

    /**
     * 计算任意位数的和，循环计算，直至值为单个数字
     * @param num
     * @return
     */
    public int calc(int num) {
        int sum = 0;
        while(true) {
            sum += num%10;
            num = num/10;
            if (num == 0 && sum < 10) {
                return sum;
            } else if(num == 0 && sum > 10) {
                num = sum;
                sum = 0;
            } else if(num == 0 && sum == 10) {
                return 1;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(new Tonghuashun().calc(101));
    }
}
