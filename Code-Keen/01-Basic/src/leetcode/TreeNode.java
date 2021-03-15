package leetcode;

public class TreeNode {
	Integer val;  // leetcode中这里可能为int类型，需要注意
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(Integer val) { this.val = val; }
	TreeNode(Integer val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}