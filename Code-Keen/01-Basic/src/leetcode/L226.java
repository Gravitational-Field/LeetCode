package leetcode;

/**
 * @ClassName L226
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/16 13:12
 * @Version 1.0
 **/
public class L226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        //根左右
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //在这里 root的left已经被改变，为先前的右子树
        invertTree(root.left);
        //在这里 root的left已经被改变，为先前的左子树
        invertTree(root.right);
        return root;
    }


}
