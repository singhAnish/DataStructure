package binarysearchtree;

import java.util.Scanner;

import binarytree.BaseTree;
import binarytree.Node;

public class BST_Validate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BaseTree baseTree = new BaseTree(scanner);

		Node<Integer> root = baseTree.createTree();

		System.out.println("Is Valid Binart Search Tree : \n" + isValidBST(root));
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
		} else if ((min != null && node.value <= min) || (max != null && node.value >= max)) {
			return false;
		} else {
			return isValid(node.left, node.value, min) && isValid(node.right, max, node.value);
		}
	}

}
