package binarytree;

import java.util.Scanner;

public class BT_Mirror {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BaseTree baseTree = new BaseTree(scanner);

		Node<Integer> root = baseTree.createTree();

		System.out.println("Tree isSymmetr : \n" + isSymmetric(root));
	}

	private static boolean isSymmetric(Node<Integer> root) {
		if (root == null) {
			return true;
		}
		return isSameTree(root.left, root.right);
	}

	private static boolean isSameTree(Node<Integer> p, Node<Integer> q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else if (p.value != q.value) {
			return false;
		} else {
			return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
		}
	}

}
