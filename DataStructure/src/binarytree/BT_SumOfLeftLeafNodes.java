package binarytree;

import java.util.List;
import java.util.Scanner;

//TIme Complexity : Linear O(n)
//SpaceComplexity = Linear O(n)
public class BT_SumOfLeftLeafNodes {

	public static void main(String[] args) {
		BaseTree baseTree = new BaseTree();
		Node<Integer> root = baseTree.createTree();
		int result = sumOfLeftLeaves(root);
		System.out.println("Result : " + result);
	}

	private static int sumOfLeftLeaves(Node<Integer> root) {
		if (root == null) {
			return 0;
		} else if (root.left != null && root.left.left == null && root.left.right == null) {
			return root.left.value + sumOfLeftLeaves(root.right);
		} else {
			return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
		}
	}

	// 2nd Way
	private static int sum = 0;

	private static void getAllLeftNodeSum(Node<Integer> root) {
		if (root == null) {
			return;
		}

		if (isLeafNode(root.left)) {
			sum = sum + root.left.value;
		}
		getAllLeftNodeSum(root.left);
		getAllLeftNodeSum(root.right);
	}

	private static boolean isLeafNode(Node<Integer> node) {
		if (node == null) {
			return false;
		}

		if (node.left == null & node.right == null) {
			return true;
		}
		return false;
	}

}
