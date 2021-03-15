package leetcode;

import java.util.*;

/**
 * @ClassName L589
 * @Description N叉树的前序遍历
 */
public class L589 {
//    private List<Integer> resultList = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        List<Integer> resultList = new ArrayList<>();


        if (root == null) return resultList;

        Collections.reverse(resultList);
//        preTraverse(root, resultList);
        return resultList;

    }

    /*private List<Integer> preTraverse(Node root, List<Integer> resultList) {
        if (root == null) return resultList;
        //根
        resultList.add(root.val);
        //下一层
        for(Node node: root.children) {
            preTraverse(node);
        }

        return resultList;
    }*/

    //迭代方式N叉树的前序边丽丽
    /*public List<Integer> preorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        if(root == null) return resultList;

        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            int curLength = stack.size();
            Node node = stack.pop();
            resultList.add(node.val);
            //将其child反序入栈
//            Collections.reverse(node.children);

             for(int i=curLength-1; i >= 0; i--) {
                 stack.push(node.children.get(i));
             }
            *//*for(Node child : node.children) {
                stack.push(child);
            }*//*
        }
        return resultList;*/
}

