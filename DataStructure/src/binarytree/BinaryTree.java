package binarytree;

import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {

		BaseTree baseTree = new BaseTree();

		Node<Integer> root = baseTree.createTree();
		TreePrinter.printNode(root);

		System.out.print("In order Traversal \t: \t");
		BaseTree.inOrderTraversal(root);
		System.out.println();
		
		System.out.print("Pre order Traversal \t: \t");
		BaseTree.preOrderTraversal(root);
		System.out.println();
		
		System.out.print("Post order Traversal \t: \t");
		BaseTree.postOrderTraversal(root);
		System.out.println();

		int height = BaseTree.maxDepth(root);
		System.out.println("Height of tree is \t: \t" + height);
	}

}
