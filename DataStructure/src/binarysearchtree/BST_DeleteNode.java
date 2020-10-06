package binarysearchtree;

import java.util.Scanner;

import binarytree.BaseTree;
import binarytree.Node;

public class BST_DeleteNode {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BaseTree baseTree = new BaseTree(scanner);
		Node<Integer> root = baseTree.createTree();
		
		int number = scanner.nextInt();
		
		Node<Integer> node = deleteNode(root, number);
		baseTree.inOrderTraversal(node);
		
	}
	
	
	private static Node<Integer> deleteNode(Node<Integer>  root, int key){
		
		if(root == null) {
			return null;
		}
		
		if(root.value < key) {
			root.right = deleteNode(root.right, key);
		}else if(root.value > key) {
			root.left = deleteNode(root.left, key);
		}else {
			if(root.left != null && root.right != null) {
				int max = findMax(root.left, Integer.MIN_VALUE);
				root.value = max;
				root.left = deleteNode(root.left, max);
				return root;
			}else if(root.left != null) {
				return root.left;
			}else if(root.right != null) {
				return root.right;
			}else {
				return null;
			}
		}
		return root;
	}
	
	private static int findMax(Node<Integer>  node, int maxValue) {
		while(node != null) {
			maxValue = Math.max(maxValue, node.value);
			node = node.right;
		}
		return maxValue;
	}

}
