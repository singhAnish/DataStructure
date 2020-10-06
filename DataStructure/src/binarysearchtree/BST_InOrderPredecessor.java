package binarysearchtree;

import java.util.Scanner;

import binarytree.BaseTree;
import binarytree.Node;

public class BST_InOrderPredecessor {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BaseTree baseTree = new BaseTree(scanner);
		Node<Integer> root = baseTree.createTree();

		System.out.print("Enter Number : \t");
		int number = scanner.nextInt();
		System.out.println("");

		Node<Integer> node = getInorderPredecessor(root, number);
		System.out.println("Inorder successor of " + number + "  :  \t" + node.value);
	}
	
	

	private static Node<Integer> getInorderPredecessor(Node<Integer> node, int number){
		if(node == null) {
			return null;
		}
		
		Node<Integer> inOrderPredecessor = null;
		
		while(node != null) {
			if(number > node.value) {
				inOrderPredecessor = node;
				node = node.right;
			}else if(number < node.value) {
				node = node.left;
			}else {
				if(node.left != null) {
					inOrderPredecessor = getPredecessor(node);
				}
				break;
			}
		}
		
		return node != null ? inOrderPredecessor : null;
	}
	
	
	private static  Node<Integer> getPredecessor(Node<Integer> node){
		if(node == null) {
			return null;
		}
		
		Node<Integer> temp = node.left;
		while(temp.right != null) {
			temp = temp.right;
		}
		return temp;
	}

}
