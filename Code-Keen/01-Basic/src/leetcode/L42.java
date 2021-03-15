package leetcode;

/**
 * @ClassName L42
 * @Description
 */
public class L42 {

    public int trap(int[] height) {
        if (height==null || height.length<=2) return 0;

        int result = 0;

        for (int i = 1; i < height.length; i++) {
            int max_left = 0;
            int max_right = 0;
            //左探索
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }

            //右探索
            for (int j = i; j < height.length; j++) {
                max_right = Math.max(max_right,height[j]);
            }

            result += Math.min(max_left,max_right) - height[i]; //当前i位置上的存水量

        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new L42().trap(height));
    }
}
