package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @ClassName L145
 * @Description 二叉树的后序遍历
 */
public class L145 {

    //递归的方式
    private List<Integer> resultList = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return resultList;

        //左
        postorderTraversal(root.left);

        //右
        postorderTraversal(root.right);

        //根
        resultList.add(root.val);

        return resultList;
    }

    //迭代的方式： 左 右  根
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            //根  右   左进行压栈
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            // root此时为空
            root = stack.pop();  //此时只知其左没有，不知其右
            //resultList.add(root.val);

            if (root.right == null || root.right == prev) {
                //右节点没有了
                resultList.add(root.val);
                prev = root;
                root = null;
            } else {
                //右节点有
                stack.push(root);
                root = root.right;  //但要防止之后再回到该右分支，使用prev记录分离点
            }
        }

        return resultList;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        //非递归方式
        //定义两个栈s1,s2，将root压入s1
        //从s1出栈，并将该节点压入s2，接着将节点的左右节点压入s1
        //重复上一步操作，直到s1为空，依此从s2中出栈即可
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        TreeNode cur = root;
        while(!s1.empty()) {
            TreeNode node = s1.pop();
            if(node.left != null) {
                s1.push(node.left);
            }
            if(node.right != null) {
                s1.push(node.right);
            }
            s2.push(node);
        }
        while(!s2.empty()) {
            TreeNode tmp = s2.pop();
            list.add(tmp.val);
        }
        return list;
    }

}
