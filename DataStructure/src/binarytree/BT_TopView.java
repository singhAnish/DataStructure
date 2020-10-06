package binarytree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

import util.Pair;

public class BT_TopView {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BaseTree baseTree = new BaseTree(scanner);

		Node<Integer> root = baseTree.createTree();
		topView(root);
	}

	private static void topView(Node<Integer> root) {

		if (root == null) {
			return;
		}

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair<Integer, Node<Integer>>> queue = new LinkedList<>();

		queue.add(new Pair<Integer, Node<Integer>>(0, root));

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Pair<Integer, Node<Integer>> pair = queue.poll();
				int height = pair.key;
				Node<Integer> tempNode = pair.value;

				if (tempNode.left != null) {
					queue.add(new Pair<Integer, Node<Integer>>(height - 1, tempNode.left));
				}

				if (tempNode.right != null) {
					queue.add(new Pair<Integer, Node<Integer>>(height + 1, tempNode.right));
				}

				if (!map.containsKey(height)) {
					map.put(height, tempNode.value);
				}
			}
		}

		for (Integer nodes : map.values()) {
			System.out.print(nodes + " ");
		}
	}

}
