package leetcode;

/**
 * @ClassName L84_1
 * @Description: 柱状图中最大面积
 * @Author Keen
 * @DATE 2021/8/10 11:41
 * @Version 1.0
 **/
public class L84_1 {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int result = 0;
        int len = heights.length;
        for (int i = 0; i < len; i++) {
            //以当前为高的，最大矩形
            int left = i;
            int right = i;
            int curArea = 0;
            while (left > 0 && heights[left - 1] >= heights[i]) left--;
            while (right < len - 1 && heights[right + 1] >= heights[i]) right++;
            curArea = (right - left + 1) * heights[i];
            result = Math.max(result, curArea);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new L84_1().largestRectangleArea(heights));
    }


}
