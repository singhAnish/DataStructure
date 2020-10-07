package binarysearchtree;

import binarytree.BaseTree;
import binarytree.Node;

public class BST_InOrderSuccessor {

	public static void main(String[] args) {
		BaseTree baseTree = new BaseTree();
		Node<Integer> root = baseTree.createTree();
		int number = baseTree.getNumber();

		Node<Integer> node = getInorderSuccesor(root, number);
		System.out.println("Inorder successor of " + number + "  :  \t" + node.value);
	}

	private static Node<Integer> getInorderSuccesor(Node<Integer> node, int value) {

		if (node == null) {
			return null;
		}

		Node<Integer> inorderSuccessor = null;

		while (node != null) {
			if (value < node.value) {
				inorderSuccessor = node;
				node = node.left;
			} else if (value > node.value) {
				node = node.right;
			} else {
				if (node.right != null) {
					inorderSuccessor = getSuccessor(node.right);
				}
				break;
			}
		}

		return node != null ? inorderSuccessor : null;
	}

	private static Node<Integer> getSuccessor(Node<Integer> node) {
		if (node == null) {
			return null;
		}

		Node<Integer> temp = node;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

}
