package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName L102
 * @Description 二叉树的层序遍历: 自顶向下
 */
public class L102 {

    //BFS  迭代的方式
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        if (root == null) return resultList;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> itemList = new LinkedList<>();

            int currentLength = queue.size();

            for (int i = 1; i <= currentLength; i++) {
                //出根，添加到itemList中
                TreeNode node = queue.poll();
                itemList.add(node.val);
                //进左
                if (node.left != null) {
                    queue.offer(node.left);
                }

                //进右
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            resultList.add(itemList);

        }
        return resultList;
    }

    //DFS  递归的方式
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        //用来存放最终结果
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(1,root,res);
        return res;
    }

    void dfs(int index,TreeNode root, List<List<Integer>> res) {
        //假设res是[ [1],[2,3] ]， index是3，就再插入一个空list放到res中
        if(res.size()<index) {
            res.add(new ArrayList<Integer>());
        }
        //将当前节点的值加入到res中，index代表当前层，假设index是3，节点值是99
        //res是[ [1],[2,3] [4] ]，加入后res就变为 [ [1],[2,3] [4,99] ]
        res.get(index-1).add(root.val);
        //递归的处理左子树，右子树，同时将层数index+1
        if(root.left!=null) {
            dfs(index+1, root.left, res);
        }
        if(root.right!=null) {
            dfs(index+1, root.right, res);
        }
    }


}
