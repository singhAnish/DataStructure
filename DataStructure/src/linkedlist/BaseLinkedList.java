package linkedlist;

import java.util.Scanner;

public class BaseLinkedList {

	private Scanner scanner;

	public BaseLinkedList() {
		this.scanner = new Scanner(System.in);
	}

	// Create a tree
	public ListNode<Integer> createLinkedList() {
		ListNode<Integer> head = null;

		System.out.print("Enter Node : \t");
		int value = scanner.nextInt();

		if (value == -1) {
			return head;
		}

		head = new ListNode<Integer>(value);
		head.next = createLinkedList();

		return head;
	}

}
