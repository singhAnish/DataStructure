package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BT_LevelTraversal {
	
	
	public static void main(String[] args) {
		BaseTree baseTree = new BaseTree();

		Node<Integer> root = baseTree.createTree();
		printLevelOrderTraversal(root);
	}
	
	
	private static void printLevelOrderTraversal(Node<Integer> root) {
		
		if(root == null) {
			return;
		}
		
		Queue<Node<Integer>> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				Node<Integer> node = queue.poll();
				
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
				
				System.out.print(node.value + "\t");
			}
			System.out.println();
		}
	}

}
