package leetcode;

import sun.reflect.generics.tree.Tree;

/**
 * @ClassName L236
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/19 16:39
 * @Version 1.0
 **/
public class L236 {

    //左  右  根
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //判断根
        if(left == null) { //左为空
            return right;
        }
        if(right == null) { //右为空
            return left;
        }

        //左右均不为空返回，root，即为最终结果
        return root;
    }

    public static void main(String[] args) {

    }
}
