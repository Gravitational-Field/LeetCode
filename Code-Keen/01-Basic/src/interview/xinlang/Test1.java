package interview.xinlang;

import java.util.*;

/**
 * @ClassName test1
 * @Description: 构建树，并进行层序遍历
 * @Author Keen
 * @DATE 2021/8/18 20:19
 * @Version 1.0
 **/
public class Test1 {

    public static class Tree{
        int data;
        Tree left;
        Tree right;
        public Tree(int data){
            this.data = data;
        }
    }

    public static Tree initTree(){
        Tree node1 = new Tree(1);
        Tree node2 = new Tree(2);
        Tree node3 = new Tree(3);
        Tree node4 = new Tree(4);
        Tree node5 = new Tree(5);
        Tree node6 = new Tree(6);
        Tree node7 = new Tree(7);
        Tree node8 = new Tree(8);
        Tree node9 = new Tree(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        node7.left = node9;
        return node1;
    }

    public static void broadFirstSearch(Tree head){
        if(head == null) return;
        //List<List>


        Queue<Tree> queue = new LinkedList<Tree>();
        queue.offer(head);

        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();

            for(int i = 1; i<=size; i++) {
                Tree node = queue.poll();
                level.add(node.data);
                System.out.print(node.data);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null ){
                    queue.offer(node.right);
                }
            }
        }
    }


    public static void main(String[] args) {
        broadFirstSearch(initTree());
    }
}


