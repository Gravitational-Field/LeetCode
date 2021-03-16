package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L98
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/16 18:23
 * @Version 1.0
 **/
public class L98 {

    List<Integer> list = new ArrayList<>();
    //根 左 右
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return false;
        }


        MidTraverse(root);

        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i) >= list.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    //中序遍历
    private void MidTraverse(TreeNode root) {
        if(root == null) {
            return;
        }

        //左  根  右
        MidTraverse(root.left);

        list.add(root.val);

        MidTraverse(root.right);
    }


}
