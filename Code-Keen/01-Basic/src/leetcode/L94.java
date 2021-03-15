package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName L94
 * @Description
 */
public class L94 {

    private List<Integer> list= new ArrayList<>();
    //中序遍历：左根右
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return list;
        //左
        inorderTraversal(root.left);
        //根
        list.add(root.val);
        //右
        inorderTraversal(root.right);
        return list;
    }

    //采用维护一个显示栈的方式来中序遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;

        Deque<TreeNode> stack = new ArrayDeque<>();

        //构建循环   左 根 右  =》  压栈顺序   根 读左， 读根  再到右侧
        while (root != null || !stack.isEmpty()) {
            //要一直走到最后
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            //此时root必定为空，则root.right也为空，如此即可保证
            root = stack.pop();
            //走到的最左边的子节点
            resultList.add(root.val);
            root = root.right;  //确保左子树遍历完，从栈中跳出根
        }
        return resultList;
    }

}
