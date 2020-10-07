package binarytree;

public class BT_Sum_of_left_leaves {

	public static void main(String[] args) {
		BaseTree baseTree = new BaseTree();
		Node<Integer> root = baseTree.createTree();
		int result = sumOfLeftLeaves(root);
		System.out.println("Result : " + result);
	
	}

	private static int sumOfLeftLeaves(Node<Integer> root) {
		if (root == null) {
			return 0;
		} else if (root.left != null && root.left.left == null && root.left.right == null) {
			return root.left.value + sumOfLeftLeaves(root.right);
		} else {
			return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
		}
	}
}
