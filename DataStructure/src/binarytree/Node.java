package binarytree;

public class Node<T extends Comparable<?>> {

	public Node<T> left, right;
	public T value;

	public Node(T value) {
		this.value = value;
		this.left = this.right = null;
	}

}
