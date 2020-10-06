package binarytree;

public class BT_FromPreOrder {

	public static void main(String[] args) {

		int[] preOrder = { 8, 5, 1, 7, 10, 12 };

		Node<Integer> node = bstFromPreorder(preOrder);
		TreePrinter.printNode(node);
	}

	private static Node<Integer> bstFromPreorder(int[] preorder) {
		return getBST(preorder, 0, preorder.length);
	}

	private static Node<Integer> getBST(int[] preOrder, int start, int end) {

		if (start >= end) {
			return null;
		}

		int rootValue = preOrder[start];
		Node<Integer> root = new Node<Integer>(rootValue);

		int rootIndex = start + 1;
		while (rootIndex < preOrder.length && preOrder[rootIndex] < rootValue) {
			rootIndex++;
		}

		root.left = getBST(preOrder, start + 1, rootIndex);
		root.right = getBST(preOrder, rootIndex, end);

		return root;

	}

}
