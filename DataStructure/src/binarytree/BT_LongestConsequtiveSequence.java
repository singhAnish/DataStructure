package binarytree;

import java.util.Scanner;

public class BT_LongestConsequtiveSequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BaseTree baseTree = new BaseTree(scanner);

		Node<Integer> root = baseTree.createTree();

		System.out.println("Longest Sequence count : \t" + longestSequence(root));
	}

	private static int longestSequence(Node<Integer> node) {
		if (node == null) {
			return 0;
		}
		return maxLongestSequence(node, null, 0);
	}

	private static int maxLongestSequence(Node<Integer> root, Node<Integer> parent, int length) {
		if (root == null) {
			return length;
		}

		if (parent != null && root.value == parent.value + 1) {
			length++;
		} else {
			length = 1;
		}

		int leftHeight = maxLongestSequence(root.left, root, length);
		int rightHeight = maxLongestSequence(root.right, root, length);

		return Math.max(length, Math.max(leftHeight, rightHeight));

	}
}
