package binarysearchtree;

import binarytree.BaseTree;
import binarytree.Node;

public class BST_Validate {

	public static void main(String[] args) {
		BaseTree baseTree = new BaseTree();
		Node<Integer> root = baseTree.createTree();
		
		System.out.println("Is Valid Binart Search Tree : \t" + isValidBST(root));
	}

	private static boolean isValidBST(Node<Integer> root) {
		if (root == null) {
			return true;
		}
		return isValid(root, null, null);
	}

	private static boolean isValid(Node<Integer> node, Integer max, Integer min) {
		if (node == null) {
			return true;
		} else if ((max != null && node.value >= max) || (min != null && node.value <= min)) {
			return false;
		} else {
			return isValid(node.left, node.value, min) && isValid(node.right, max, node.value);
		}
	}

}
