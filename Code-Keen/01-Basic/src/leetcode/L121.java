package leetcode;

/**
 * @ClassName L121
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/24 11:31
 * @Version 1.0
 **/
public class L121 {

    //暴力解法，超出时间限制
    public int maxProfit1(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                res = Math.max(res, prices[j]-prices[i]);
            }
        }

        return res;
    }

    //一次遍历
    public int maxProfit(int[] prices) {

        int res = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            res = Math.max(res, prices[i]-minPrice);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(new L121().maxProfit(prices));
    }
}
