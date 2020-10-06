package binarysearchtree;

import binarytree.BaseTree;
import binarytree.Node;

public class BST_Cousions {
	
	public static void main(String[] args) {
		BaseTree baseTree = new BaseTree();

		Node<Integer> root = baseTree.createTree();

		if (iterative(root, 5, 6)) {
			System.out.print("Given nodes are cousins");
		} else {
			System.out.print("Given nodes are not cousins");
		}
	}

	// Data structure to store a Binary Tree node along with its level and parent information
	static class NodeInfo {
		int key;
		int level;
		Node<Integer> parent = null;

		NodeInfo(int key, int level, Node<Integer> parent) {
			this.key = key;
			this.level = level;
			this.parent = parent;
		}
	}

	// Perform in-order traversal of the binary tree and update x and y
	public static void inorder(Node<Integer> root, Node<Integer> parent, int level, NodeInfo x, NodeInfo y) {
		if (root == null) {
			return;
		}

		// traverse left subtree
		inorder(root.left, root, level + 1, x, y);

		// if first element is found, save its level and parent node
		if (root.value == x.key) {
			x.level = level;
			x.parent = parent;
		}

		// if second element is found, save its level and parent node
		if (root.value == y.key) {
			y.level = level;
			y.parent = parent;
		}

		// traverse right subtree
		inorder(root.right, root, level + 1, x, y);
	}

	// Function to determine if two given nodes are cousins of each other
	public static boolean iterative(Node<Integer> root, int elem1, int elem2) {
		if (root == null) {
			return false;
		}

		int level = 1; // level of root is 1
		Node<Integer> parent = null; // parent of root is null

		NodeInfo x = new NodeInfo(elem1, level, parent);
		NodeInfo y = new NodeInfo(elem2, level, parent);

		// perform in-order traversal of the array and update x and y
		inorder(root, null, 1, x, y);

		// return false if x and y have different level or same parent
		if (x.level != y.level || x.parent == y.parent) {
			return false;
		}

		return true;
	}
}