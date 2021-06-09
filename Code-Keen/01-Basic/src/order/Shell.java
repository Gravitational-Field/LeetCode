package order;

/**
 * @ClassName Shell
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/6/1 10:05
 * @Version 1.0
 **/
public class Shell<T extends Comparable<T>> extends Sort<T>  {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        int h = 1;

        while (h < N / 3) { //确定初始的h
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) { //从此往后
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {  //每次都往前比
                    swap(nums, j, j - h);
                }
            }
            h = h / 3; //比完一轮，更新h值
        }
    }
}
