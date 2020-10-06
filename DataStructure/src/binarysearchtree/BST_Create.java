package binarysearchtree;

import binarytree.Node;

public class BST_Create {

	public static void main(String[] args) {
	    Node<Integer> root = null;
	    
	    root = insert(root, 8);
	    root = insert(root, 3);
	    root = insert(root, 6);
	    root =insert(root, 10);
	    root =insert(root, 4);
	    root = insert(root, 7);
	    root = insert(root, 1);
	    root = insert(root, 14);
	    root =insert(root, 13);
	    
	  }

	public static Node<Integer> insert(Node<Integer> node, int val) {
		if (node == null) {
			return new Node<Integer>(val);
		}

		if (val < node.value) {
			node.left = insert(node.left, val);
		} else if ((val > node.value)) {
			node.right = insert(node.right, val);
		}

		return node;
	}
}
