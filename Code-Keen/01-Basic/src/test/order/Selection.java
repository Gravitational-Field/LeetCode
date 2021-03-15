package test.order;

/**
 * @ClassName Selection
 * @Description  选择排序
 */
public class Selection<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        if (nums == null || nums.length == 0) return;

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i+1; j < len; j++) {
                if (less(nums[j],nums[min])) {
                    min = j;
                }
            }
            swap(nums, i, min);

        }



    }
}
