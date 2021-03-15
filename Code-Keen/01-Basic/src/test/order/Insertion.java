package test.order;

/**
 * @ClassName Insertion
 * @Description  插入排序   以及其改良
 * 折半插入排序：每一次在前边找第i位的位置时，都需要不断地进行交换，由于前边序列是有序的，
 * 可以采用折半查找的方式，快速找到该元素的序列位置，将该位置的向后移动，并将该元素置于指定位置
 * 如此，节省了交换的次数，从而提高效率
 */
public class Insertion<T extends Comparable<T>> extends Sort<T>{

    @Override
    public void sort(T[] nums) {
        if (nums == null || nums.length == 0) return;

        int len = nums.length;
        for (int i = 1; i < len; i++) { //每一轮要确定前i位

            for (int j = i; j > 0 && less(nums[j],nums[j-1]); j--) { //进行i位之前的排序
                swap(nums,j,j-1);
            }
        }
    }
}
