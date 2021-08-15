package leetcode;

/**
 * @ClassName L11_1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/7 9:52
 * @Version 1.0
 **/
public class L11_1 {

    // 导致超出时间限制
    public int maxArea1(int[] height) {
        //思路：暴力求解
        if (height == null || height.length == 0 || height.length == 1) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                result = Math.max(area, result);
            }
        }
        return result;
    }

    //双指针的方式
    public int maxArea(int[] height) {
        //思路：双指针
        if (height == null || height.length == 0 || height.length == 1) {
            return 0;
        }
        int result = 0;
        int j = height.length - 1;
        for (int i = 0; i < j; i++) {
            int area = (j - i) * Math.min(height[i], height[j]);
            result = Math.max(area, result);
            //进行变换，j--:后边小
            if(height[j]<height[i]) {
                j--;
                i--;
            }
        }
        return result;
    }


}
