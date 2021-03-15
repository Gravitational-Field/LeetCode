package leetcode;

public class BinaryTree {

	leetcode.TreeNode root;

	public BinaryTree(Integer[] array) {
		root = createBinaryTreeByArray(array, 0);
	}

	private TreeNode createBinaryTreeByArray(Integer[] array, int index) {
		TreeNode tn = null;
		if (index < array.length) {
			Integer value = array[index];
//			if (value == null) return null;  //为null也需要构建进去
			tn = new TreeNode(value);
			tn.left = createBinaryTreeByArray(array, 2 * index + 1);
			tn.right = createBinaryTreeByArray(array, 2 * index + 2);
			return tn;
		}
		return tn;
	}

	public void preOrderTraverse(TreeNode root) {
		if (root == null) return;
		//根
		if (root.val != null) { //不为空时输出
			System.out.print(root.val+"  ");
		}
		//左
		preOrderTraverse(root.left);

		//右
		preOrderTraverse(root.right);
	}

	public void inOrderTraverse(TreeNode root) {
		if (root == null) return;
		//左
		inOrderTraverse(root.left);
		//根
		if (root.val != null) { //不为空时输出
			System.out.print(root.val+"  ");
		}
		//右
		inOrderTraverse(root.right);
	}


	public void postOrderTraverse(TreeNode root) {
		if (root == null) return;

		//左
		postOrderTraverse(root.left);

		//右
		postOrderTraverse(root.right);

		//根
		if (root.val != null) { //不为空时输出
			System.out.print(root.val+"  ");
		}
	}

	public static void main(String[] args) {
		Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};
		BinaryTree binaryTree = new BinaryTree(nums);
		/*先序遍历测试*/
		binaryTree.preOrderTraverse(binaryTree.root);  // 5 4 11 7 2 8 13 1 4
		System.out.println();
		binaryTree.inOrderTraverse(binaryTree.root);  // 7 11 2 4 5 13 1 8 4
		System.out.println();
		binaryTree.postOrderTraverse(binaryTree.root); // 7 2 11 4 1 13 4 8 5

	}
}