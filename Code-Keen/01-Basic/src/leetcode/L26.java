package leetcode;

import java.util.Arrays;

/**
 * @ClassName L26
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/17 19:38
 * @Version 1.0
 **/
public class L26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;// p进行保留
        int q = 1;//探索者

        while(q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p+1] = nums[q];
                p++;
            }
            q++;
        }
        return p+1;
    }
}
