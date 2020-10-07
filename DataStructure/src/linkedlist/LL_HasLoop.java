package linkedlist;

import linkedlist.MyLinkedList.Node;

public class LL_HasLoop {

	public static void main(String[] args) {

		MyLinkedList list = new MyLinkedList();

		list.head = new Node(1);
		list.head.next = new Node(2);
		Node node = list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		list.head.next.next.next.next.next = node;

		System.out.println("Has Loop? " + hasLoop(list.head));

	}

	private static boolean hasLoop(Node head ) {
		Node slow = head;
		Node fast = head;

		boolean loop = false;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				loop = true;
				break;
			}
		}

		return loop;
	}
}
