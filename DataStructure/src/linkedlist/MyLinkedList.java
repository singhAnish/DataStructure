package linkedlist;

public class MyLinkedList {

	public Node head;

	public static class Node {
		public Node next;
		public Object data;
		public Node(Object data) {
			this.data = data;
			next = null;
		}
	}
}
