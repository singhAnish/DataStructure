package binarytree;

public class BT_FromInorderandPostOrder {

	public static void main(String[] args) {

		int[] inOrder = { 9, 3, 15, 20, 7 };
		int[] postOrder = { 9, 15, 7, 20, 3 };

		Node<Integer> node = buildTree(inOrder, postOrder);
		TreePrinter.printNode(node);
	}

	private static Node<Integer> buildTree(int[] inorder, int[] postorder) {
		return constructTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
	}

	private static Node<Integer> constructTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart > inEnd) {
			return null;
		}

		int rootValue = postorder[postEnd];
		Node<Integer> root = new Node<Integer>(rootValue);

		int rootIndex = inStart;
		while (inorder[rootIndex] != rootValue) {
			rootIndex++;
		}
		
		int leftTreeSize = rootIndex - inStart;
		int rightTreeSize = inEnd - rootIndex;

		root.left = constructTree(inorder, postorder, inStart, rootIndex - 1, postStart,  postStart + leftTreeSize - 1);
		root.right = constructTree(inorder, postorder, rootIndex + 1, inEnd, postEnd -  rightTreeSize ,postEnd - 1);

		return root;

	}

}
