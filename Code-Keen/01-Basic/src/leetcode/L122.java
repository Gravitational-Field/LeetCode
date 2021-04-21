package leetcode;

/**
 * @ClassName L122
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/4/12 21:52
 * @Version 1.0
 **/
public class L122 {


    //最大利润：
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] array = {7,1,5,3,6,4};
        System.out.println(new L122().maxProfit(array));
    }
}
