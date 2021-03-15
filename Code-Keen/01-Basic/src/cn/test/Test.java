package cn.test;

import cn.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

public class Test {

    public void test1() {
        String data = "1,2,#,4,#,#,3,#,#,";
        String[] nodes = data.split(",");
        System.out.println(deserialize(data));
        LinkedList<String> list = new LinkedList();
//        list.add
//        new LinkedBlockingDeque<>()
    }

    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        return decoder(dataArr, 0);

    }

    public TreeNode decoder(String[] dataArr,int index) {
        //主要任务是构建节点;采用  前序遍历的方式   根左右
        //if(dataArr == null || dataArr.length == 0){
        //    return null;
        //}
        if(dataArr == null || index > dataArr.length){
            index++;
            return null;
        }
        //数组不为空
        String first = dataArr[index];
        if("#".equals(first)){
            index++;
            return null;
        }

        int val = Integer.parseInt(first);
        //根   左右
        TreeNode root = new TreeNode(val);
        root.left = decoder(dataArr, index++);  //索引左右这里会出现问题
        root.right = decoder(dataArr,index++);
        return root;
    }
}
