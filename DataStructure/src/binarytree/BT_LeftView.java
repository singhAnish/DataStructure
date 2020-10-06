package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BT_LeftView {
	
	static int maxLevel = 0;

	public static void main(String[] args) {
		BaseTree baseTree = new BaseTree();

		Node<Integer> root = baseTree.createTree();
		
		List<Integer> list = leftSideViewRecursive(root);
		System.out.println(list.toString());
		//leftSideView(root);
	}

	private  static List<Integer> leftSideViewRecursive(Node<Integer> root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		getLeftView(root, 1, list);
		return list;
	}

	private static void getLeftView(Node<Integer> node, int level, List<Integer> list) {
		if (node == null) {
			return;
		}

		if (level > maxLevel) {
			list.add(node.value);
			maxLevel++;
		}

		getLeftView(node.left, level + 1, list);
		getLeftView(node.right, level + 1, list);
	}

	
	//Right View using queue and level order traversal
	private static  List<Integer> leftSideView(Node<Integer> root) {

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

				if (i == 0) {
					list.add(node.value);
				}
			}
		}

		return list;
	}

}
