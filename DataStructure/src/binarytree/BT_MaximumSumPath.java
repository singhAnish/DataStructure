package binarytree;

public class BT_MaximumSumPath {

	private static int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) {
		BaseTree baseTree = new BaseTree();
		Node<Integer> root = baseTree.createTree();
		System.out.println("Maximum sum path : \t" + maxPathSum(root));
	}

	private static int maxPathSum(Node<Integer> root) {
		int sum = getMaxSum(root);
		return Math.max(sum, maxSum);
	}

	private static int getMaxSum(Node<Integer> root) {
		if (root == null) {
			return 0;
		}

		int leftSum = Math.max(getMaxSum(root.left), 0);
		int rightSum = Math.max(getMaxSum(root.right), 0);

		int sum = root.value + leftSum + rightSum;
		maxSum = Math.max(maxSum, sum);

		return root.value + Math.max(leftSum, rightSum);
	}
}
