package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L257
 * @Description: 二叉树的所有路径
 * @Author Keen
 * @DATE 2021/3/23 21:23
 * @Version 1.0
 **/
public class L257 {

    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return res;
        }
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String str) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            str += root.val;
            res.add(str);
            //System.out.println(res.toString());
            return;
        }
        str += root.val+"->";

        dfs(root.right, str);
        System.out.println(str);
        dfs(root.left, str);
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,null,5};
        BinaryTree binaryTree = new BinaryTree(array);
        L257 l257 = new L257();

        l257.binaryTreePaths(binaryTree.root);
        //System.out.println("hahah");
        //binaryTree.preOrderTraverse(binaryTree.root);
        System.out.println(l257.res.toString());
    }
}
