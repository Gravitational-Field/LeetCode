package cn.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class TreeNode {

    static HashMap<String, Integer> map = new HashMap();
    int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        //获取最大值
        //System.out.println(Arrays.stream(nums).max().getAsInt());

        //nums.length
        //for (int num : nums) {
        //    System.out.println(num);
        //}
        //TreeNode root = constructMaximumBinaryTree(nums[0,3]);

        //System.out.println(Arrays.toString(nums));

        //map.getOrDefault("abc",)
        TreeNode root = constructMaximumBinaryTree(nums);
        System.out.println(root);
        Deque<TreeNode> deque = new LinkedList<>();
        
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    private static TreeNode build(int[] nums, int low, int high) {
        if(low > high){
            return null;
        }

        int maxVal = Integer.MIN_VALUE;
        int index = -1;
        for (int i = low; i <= high; i++) {
            if(nums[i] > maxVal){
                maxVal = nums[i];
                index = i;
            }
        }

        //构建root  根左右
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, low, index-1);
        root.right = build(nums, index+1, high);

        //返回根
        return root;
    }
}