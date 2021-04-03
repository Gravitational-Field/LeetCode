package leetcode;

/**
 * @ClassName L105
 * @Description: 从前序和中序遍历构造二叉树
 * @Author Keen
 * @DATE 2021/3/20 9:19
 * @Version 1.0
 **/
public class L105 {

    //先序遍历构建  根 左 右
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_stop, int[] inorder, int i_start, int i_stop) {
        if(p_start == p_stop) {
            return null;
        }

        int root_val = preorder[p_start];
        //根左右
        TreeNode root = new TreeNode(root_val);

        //找到中序中当前根的位置
        /*int i; //记录位置
        for (i = i_start; i < i_stop; i++) {
            if(inorder[i] == root.val) {
                break;
            }
        }*/
        int i_root_index = 0;
        for (int i = i_start; i < i_stop; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }

        int p_right_num = i_root_index-i_start;
        root.left = buildTreeHelper(preorder, p_start+1, p_start+p_right_num+1, inorder, i_start, i_root_index);
        root.right = buildTreeHelper(preorder, p_start+p_right_num+1, p_stop, inorder, i_root_index+1, i_stop);

        return root;
    }


    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = new L105().buildTree(preorder, inorder);

    }

}
