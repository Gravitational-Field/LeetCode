package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName L84
 * @Description
 */
public class L84 {

    //暴力解法  时间复杂度太高
    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int maxArea = 0;
        //遍历高，左右找比其小的，看面积
        for (int i = 0; i < heights.length; i++) {
            //以一个高位基,因为要左右摇摆，所以不能用forj遍历
            //先左
            int left = i;
            int currentHeight = heights[i];
            while (left>0 && heights[left-1] >= currentHeight) {
                left--;
            }

            //后右
            int right = i;
            while (right<heights.length-1 && heights[right+1] >= currentHeight) {
                right++;
            }

            int width = right-left+1;
            maxArea = Math.max(maxArea, width * currentHeight);
        }

        return maxArea;

    }

    //单调栈+哨兵技巧
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] heights = {2,1,5,6,2,3};
        int[] heights = {6,6};
        System.out.println(new L84().largestRectangleArea2(heights));
    }

}
