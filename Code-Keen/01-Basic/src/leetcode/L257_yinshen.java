package leetcode;

import java.util.*;

/**
 * @ClassName L257_yinshen
 * @Description: 二叉树的所有节点路径
 * @Author Keen
 * @DATE 2021/3/29 8:49
 * @Version 1.0
 **/
public class L257_yinshen {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();
    public List<List<Integer>> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return res;
        }
        dfs(root, deque);
        return res;
    }

    private void dfs(TreeNode root, Deque<Integer> deque) {
        if(root == null) {
            return;
        }

        deque.push(root.val);
        List<Integer> list = new ArrayList<>(deque);
        Collections.reverse(list);
        res.add(list);

        dfs(root.left, deque);
        //deque.pop();
        dfs(root.right, deque);
        deque.pop();
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,4,5};
        BinaryTree binaryTree = new BinaryTree(array);
        L257_yinshen l257_yinshen = new L257_yinshen();

        l257_yinshen.binaryTreePaths(binaryTree.root);
        //System.out.println("hahah");
        //binaryTree.preOrderTraverse(binaryTree.root);
        System.out.println(l257_yinshen.res.toString());
        // [[1], [1, 2], [1, 2, 4], [1, 2, 5], [1, 3]]
    }
}
