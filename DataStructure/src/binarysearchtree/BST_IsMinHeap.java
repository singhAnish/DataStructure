package binarysearchtree;

import java.util.Scanner;

import binarytree.BaseTree;
import binarytree.Node;

public class BST_IsMinHeap {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BaseTree baseTree = new BaseTree(scanner);

		Node<Integer> root = baseTree.createTree();
		System.out.println("Is Valid Binart Search Tree : \n" + isHeap(root));
	}

	public static boolean isHeap(Node<Integer> root) {
		int i = 0;
		return isHeap(root, i, size(root));
	}

	private static boolean isHeap(Node<Integer> root, int i, int n) {
		if (root == null) {
			return true;
		}

		if (i >= n) {
			return false;
		}

		if ((root.left != null && root.left.value <= root.value)
				|| (root.right != null && root.right.value <= root.value)) {
			return false;
		}
		return isHeap(root.left, 2 * i + 1, n) && isHeap(root.right, 2 * i + 2, n);
	}

	private static int size(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		return 1 + size(root.left) + size(root.right);
	}
}
