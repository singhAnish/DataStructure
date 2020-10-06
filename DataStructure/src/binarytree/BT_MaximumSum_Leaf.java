package binarytree;

public class BT_MaximumSum_Leaf {

	private static int maxSumBetweenTwoLeaves = 0;

	public static void main(String[] args) {
		BaseTree baseTree = new BaseTree();
		Node<Integer> root = baseTree.createTree();
		System.out.println("Max pathSum  " + getMaxSumPathBetweenTwoLeaves(root));
	}

	private static int getMaxSumPathBetweenTwoLeaves(Node<Integer> node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return node.value;
		}

		int left = getMaxSumPathBetweenTwoLeaves(node.left);
		int right = getMaxSumPathBetweenTwoLeaves(node.right);

		if (node.left != null && node.right != null) {
			maxSumBetweenTwoLeaves = Math.max(maxSumBetweenTwoLeaves, left + right + node.value);
			return Math.max(left, right) + node.value;
		}

		return node.left != null ? left + node.value : right + node.value;
	}
}
