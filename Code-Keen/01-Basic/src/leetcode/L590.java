package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName L590
 * @Description N叉树的后序遍历
 */
public class L590 {

    // N叉树的后序遍历：递归方式
    /*public List<Integer> postorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        if(root == null) return resultList;

        postTraverse(root, resultList);
        return resultList;
    }

    private void postTraverse(Node root, List<Integer> resultList) {
        if(root == null) return;

        //左右
        for(Node node:root.children) {
            postTraverse(node, resultList);
        }
        //根
        resultList.add(root.val);
    }*/

    //
    /*public List<Integer> postorder(Node root) {
        LinkedList<Integer> resultList = new LinkedList<>();  //只有LinkedList才可以
        if(root == null) return resultList;

        Deque<Node> stack = new LinkedList<>();
        stack.push(root);

        //
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            //头插
            resultList.addFirst(node.val);

            for(Node child: node.children) {
                //从左到右入栈，则出栈顺序为从右到左
                stack.push(child);
            }
        }
        return resultList;
    }*/

}
