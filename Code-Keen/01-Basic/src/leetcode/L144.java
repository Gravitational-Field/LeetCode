package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName L144
 * @Description
 */
public class L144 {

    //递归版的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;

        preOrder(root, resultList);
        return resultList;
    }

    private void preOrder(TreeNode root, List<Integer> resultList) {
        if (root == null) return;

        //根
        resultList.add(root.val);
        //左
        preOrder(root.left, resultList);
        //右
        preOrder(root.right, resultList);
    }


    //使用栈的方式遍历
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        //根左右
        while (!stack.isEmpty()) {

            TreeNode treeNode = stack.pop();
            if (treeNode.val != null) {
                resultList.add(treeNode.val);
            }

            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }

            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Integer[] array = {1,null,2,3};
        BinaryTree binaryTree = new BinaryTree(array);
        System.out.println(new L144().preorderTraversal1(binaryTree.root));

    }

}
