package leetcode;

/**
 * @ClassName L111
 * @Description: 二叉树的最小深度
 * @Author Keen
 * @DATE 2021/3/16 19:39
 * @Version 1.0
 **/
public class L111 {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }

        //左  右  根
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(root.left != null && root.right == null) {
            return left+1;
        }
        
        if(root.left == null && root.right != null) {
            return right+1;
        }
        //左右都不为空
        return Math.min(left, right)+1;
    }


}
