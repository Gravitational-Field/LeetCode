package leetcode;

/**
 * @ClassName L106
 * @Description: 中序遍历 和  后序遍历
 * @Author Keen
 * @DATE 2021/3/20 13:40
 * @Version 1.0
 **/
public class L106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return buildTreeHelper(inorder, 0, inorder.length-1, postorder,0, postorder.length-1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int i_start, int i_stop, int[] postorder, int p_start, int p_stop) {
        //结束条件
        if(p_start > p_stop || i_start > i_stop) {
            return null;
        }

        //根  左  右
        TreeNode root = new TreeNode(postorder[p_stop]);

        int i_root_index = 0;
        for (int i = i_start; i <= i_stop; i++) {
            if(inorder[i] == root.val) {
                i_root_index = i;
                break;
            }
        }

        int leftNum = i_root_index-i_start;
        int rightNum = i_stop-i_root_index;

        root.left = buildTreeHelper(inorder, i_start, i_root_index-1, postorder,  p_start,p_start+leftNum-1);
        root.right = buildTreeHelper(inorder, i_root_index+1, i_stop, postorder, p_start+leftNum, p_stop-1); //p_stop-rightNum

        return root;
    }

    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = new L106().buildTree(inorder, postorder);
    }

}
