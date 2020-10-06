package binarytree;

import util.Pair;

// Time Complexity O(n)
public class BT_Diameter {

	public static void main(String[] args) {
		BaseTree baseTree = new BaseTree();
		Node<Integer> root = baseTree.createTree();

		System.out.println("Diameter of tree : \t" + diameterOfBinaryTree(root));
	}

	// Time Complexity : O(n^2)
	// If complete binary tree O(n*log(n) else if all node are are one side then O(n^2)
	public static int diameterSimpleRecursion(Node<Integer> root) {
		if (root == null) {
			return 0;
		}

		int solution1 = BaseTree.maxDepth(root.left) + BaseTree.maxDepth(root.right);
		int solution2 = diameterSimpleRecursion(root.left);
		int solution3 = diameterSimpleRecursion(root.right);
		return Math.max(solution1, Math.max(solution2, solution3));
	}

	// Time Complexity : O(n)
	public static int diameterOfBinaryTree(Node<Integer> root) {
		if (root == null) {
			return 0;
		}

		Pair<Integer, Integer> output = getHeightDiameter(root);
		return output.value;
	}

	private static Pair<Integer, Integer> getHeightDiameter(Node<Integer> root) {

		Pair<Integer, Integer> output = new Pair<>(0, 0);
		if (root == null) {
			return output;
		}

		Pair<Integer, Integer> leftOutput = getHeightDiameter(root.left);
		Pair<Integer, Integer> rightOutput = getHeightDiameter(root.right);

		int height = 1 + Math.max(leftOutput.getKey(), rightOutput.getKey());

		int option1 = leftOutput.getKey() + rightOutput.getKey();
		int option2 = leftOutput.getValue();
		int option3 = rightOutput.getValue();

		output.setKey(height);
		output.setValue(Math.max(option1, Math.max(option2, option3)));

		return output;
	}

}
