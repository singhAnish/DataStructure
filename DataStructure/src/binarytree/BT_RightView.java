package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BT_RightView {

	static int maxLevel = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BaseTree baseTree = new BaseTree(scanner);

		Node<Integer> root = baseTree.createTree();
		
		rightSideViewRecursive(root);
		//rightSideView(root);
	}

	private  static List<Integer> rightSideViewRecursive(Node<Integer> root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		getRightView(root, 1, list);
		return list;
	}

	private static void getRightView(Node<Integer> node, int level, List<Integer> list) {
		if (node == null) {
			return;
		}

		if (level > maxLevel) {
			list.add(node.value);
			maxLevel++;
		}

		getRightView(node.right, level + 1, list);
		getRightView(node.left, level + 1, list);
	}

	
	//Right View using queue and level order traversal
	private static  List<Integer> rightSideView(Node<Integer> root) {

		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		Queue<Node<Integer>> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Node<Integer> node = queue.poll();

				if (node.left != null)
					queue.add(node.left);

				if (node.right != null)
					queue.add(node.right);

				if (i == size - 1) {
					list.add(node.value);
				}
			}
		}

		return list;
	}

}
