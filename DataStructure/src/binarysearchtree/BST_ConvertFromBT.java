package binarysearchtree;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import binarytree.BaseTree;
import binarytree.Node;

public class BST_ConvertFromBT {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BaseTree baseTree = new BaseTree(scanner);
		Node<Integer> root = baseTree.createTree();

		Set<Integer> set = new TreeSet<>();
		extractKeys(root, set);

		// put back keys present in set in their correct order in BST
		Iterator<Integer> it = set.iterator();
		convertToBST(root, it);

		// print the BST
		inorder(root);
	}

	public static void inorder(Node<Integer> root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.value + " ");
		inorder(root.right);
	}

	public static void extractKeys(Node<Integer> root, Set<Integer> set) {
		if (root == null) {
			return;
		}
		extractKeys(root.left, set);
		set.add(root.value);
		extractKeys(root.right, set);
	}

	public static void convertToBST(Node<Integer> root, Iterator<Integer> it) {
		if (root == null) {
			return;
		}
		convertToBST(root.left, it);
		root.value = it.next();
		convertToBST(root.right, it);
	}
}
