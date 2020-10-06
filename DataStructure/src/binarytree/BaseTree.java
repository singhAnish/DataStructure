package binarytree;

import java.util.Scanner;

public class BaseTree {
	private Scanner scanner;

	public BaseTree(Scanner scanner) {
		this.scanner = scanner;
	}

	// Create a tree
	public Node<Integer> createTree() {
		Node<Integer> root = null;

		System.out.print("Enter Data : \t");
		int data = scanner.nextInt();

		if (data == -1) {
			return root;
		}

		root = new Node<Integer>(data);

		System.out.println("Enter left data for : " + data + " :\t");
		root.left = createTree();

		System.out.println("Enter right data for : " + data + " :\t");
		root.right = createTree();

		return root;
	}

	// In order Traversal
	public static void inOrderTraversal(Node<Integer> root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.value);
		inOrderTraversal(root.right);
	}

	// Pre order Traversal
	public static void preOrderTraversal(Node<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.value);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	// Post order Traversal
	public static void postOrderTraversal(Node<Integer> root) {
		if (root == null) {
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.value);
	}

	// Get Depth of tree
	public static int maxDepth(Node<Integer> root) {
		if (root == null) {
			return 0;
		}

		int lDepth = maxDepth(root.left);
		int rDepth = maxDepth(root.right);

		return 1 + Math.max(lDepth, rDepth);
	}

}
