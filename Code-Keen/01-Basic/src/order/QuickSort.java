package order;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        //shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l)
            return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true) {
            while (less(nums[++i], v) && i != h) ;   //从左往右找第一个大于 v 的
            while (less(v, nums[--j]) && j != l) ;   //从右往左找第一个小于v的,一定要j能等于l
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);  //j当前位置是从后往前，最后一个小于v的值
        return j;
    }

    public static void main(String[] args) {
        //Integer[] array = {5, 1, 2,7,9,8,6,3,9};
        Integer[] array = {1, 5, 8, 9, 2, 4, 5, 6};
        QuickSort<Integer> integerQuickSort = new QuickSort<>();
        integerQuickSort.sort(array);
        System.out.println(Arrays.toString(array));

    }
}