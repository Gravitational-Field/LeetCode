package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L102_1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/4/9 8:47
 * @Version 1.0
 **/
public class L102_1 {

    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return resultList;
        }
        dfs(root, 0);
        return resultList;
    }

    private void dfs(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        /**
         * 说明了当前层级数 > 结果集的长度
         * 就需要创建一个新的数组来包含相应的节点元素
         */
        if( level > resultList.size()-1 ){
            resultList.add(new ArrayList<>());
        }

        //处理根
        resultList.get(level).add(root.val);


        if(root.left != null) {
            dfs(root.left, level+1);
        }

        if(root.right != null) {
            dfs(root.right, level+1);
        }
    }

    public static void main(String[] args) {
        Integer[] array = {3,9,20,null,null,15,7};
        BinaryTree binaryTree = new BinaryTree(array);
        System.out.println(new L102_1().levelOrder(binaryTree.root));
    }
}
