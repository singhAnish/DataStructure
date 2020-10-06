package binarytree;

import java.util.HashMap;
import java.util.Map;

public class BT_FromInorderandPreOrder {

	private static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {

		int[] inOrder = { 9, 3, 5, 8, 7 };
		int[] preOrder = { 3, 9, 8, 5, 7 };

		Node<Integer> node = buildTree(preOrder, inOrder);
		TreePrinter.printNode(node);
	}

	private static Node<Integer> buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return constructTree(preorder, inorder, 0, preorder.length - 1, 0);

	}

	private static Node<Integer> constructTree(int[] preorder, int[] inorder, int start, int end, int index) {
		if (start > end) {
			return null;
		}

		Node<Integer> root = new Node<Integer>(preorder[index]);
		int inIndex = map.get(preorder[index]);

		root.left = constructTree(preorder, inorder, start, inIndex - 1, index + 1);
		root.right = constructTree(preorder, inorder, inIndex + 1, end, index + inIndex - start + 1);

		return root;
	}
}
