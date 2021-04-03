package leetcode;

/**
 * @ClassName L105_1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/22 8:21
 * @Version 1.0
 **/
public class L105_1 {

    public TreeNode buildTree(Integer[] preorder, Integer[] inorder) {

        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(Integer[] preorder, int p_start, int p_end, Integer[] inorder, int i_start, int i_emd) {
        //结束条件
        if(p_start > p_end) { //由于是按照索引来进行，所以相等的时候，必须也构建了；
            return null;
        }

        //构建根节点
        TreeNode root = new TreeNode(preorder[p_start]);

        //寻找在中序中的索引
        int i_root_index = 0;
        for (int i = p_start; i <= i_emd; i++) {
            if(inorder[i] == root.val) {
                i_root_index = i;
                break;
            }
        }

        int leftNum = i_root_index-i_start;
        //int rightNum = i_emd-i_root_index;
        //左
        root.left = buildTree(preorder, p_start+1, p_start+leftNum, inorder, i_start, i_root_index-1);
        //右
        root.right = buildTree(preorder, p_start+leftNum+1, p_end, inorder, i_root_index+1, i_emd);

        return root;

    }

    public static void main(String[] args) {
        Integer[] preorder = {3,9,20,15,7};
        Integer[] inorder = {9,3,15,20,7};
        TreeNode root = new L105_1().buildTree(preorder, inorder);

    }


}
