package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BT_LevelAverage {

	public static void main(String[] args) {
		BaseTree baseTree = new BaseTree();

		Node<Integer> root = baseTree.createTree();
		System.out.println("Average  of tree : \t" + averageOfLevels(root));
	}

	public static List<Double> averageOfLevels(Node<Integer> root) {
		List<Double> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Queue<Node<Integer>> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			double sum = 0;
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Node<Integer> node = queue.poll();
				sum += node.value;

				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);

			}
			result.add(sum / size);
		}
		return result;
	}

}
