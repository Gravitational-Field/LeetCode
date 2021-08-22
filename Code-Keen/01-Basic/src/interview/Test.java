package interview;

/**
 * @ClassName Test
 * @Description 最大水面积
 */
public class Test {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) return 0;

        int result = 0;

        for (int i = 1; i < height.length-1; i++) {
            int curArea = 0;
            int left = i-1;
            int right = i+1;
            //循环，找到以height[i]为基的最大面积,
            for (int j = left; j >= 0; j--) {
                //左边找比其低的那个值的索引


            }

            for (int j = right; j <= height.length; j++) {
                //右边找比其高的那个值的索引


            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(new Test().maxArea(height));


    }

}
