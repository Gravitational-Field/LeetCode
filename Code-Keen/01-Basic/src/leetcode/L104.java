package leetcode;

/**
 * @ClassName L104
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/16 18:54
 * @Version 1.0
 **/
public class L104 {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right)+1;
        }
    }

    //使用公共的变量时
    int max = Integer.MIN_VALUE;
    public int maxDepth1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        traverse(root,1);
        return max;
    }

    private void traverse(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            max = Math.max(max, level);
        }
        traverse(root.left, level+1);
        traverse(root.right,level+1);
    }

    public static void main(String[] args) {
        Integer[] nums = {2,3,2,4,6};
        BinaryTree binaryTree = new BinaryTree(nums);

        System.out.println(new L104().maxDepth(binaryTree.root));
    }

}
