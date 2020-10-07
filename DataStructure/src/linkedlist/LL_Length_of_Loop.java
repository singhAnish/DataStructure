package linkedlist;

import linkedlist.MyLinkedList.Node;

public class LL_Length_of_Loop {

	public static void main(String[] args) {

		MyLinkedList list = new MyLinkedList();

		list.head = new Node(1);
		list.head.next = new Node(2);
		Node node = list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		list.head.next.next.next.next.next = node;

		System.out.println("Length of loop: " + lengthOfLoop(list));
	}

	private static int lengthOfLoop(MyLinkedList myLinkedList) {
		Node head = myLinkedList.head;
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

		if (loop) {
			int length = 0;
			slow = head;

			while (fast != slow) {
				fast = fast.next;
				slow = slow.next;
			}

			do {
				fast = fast.next;
				length++;
			} while (fast != slow);

			return length;
		}
		return 0;
	}
}
