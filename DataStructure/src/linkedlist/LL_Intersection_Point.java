package linkedlist;

import linkedlist.MyLinkedList.Node;

// Time complexity : O(m+n)
// Space complexity : O(1)
public class LL_Intersection_Point {

	public static void main(String[] args) {
		// creating first linked list
		MyLinkedList list = new MyLinkedList();
		list.head = new Node(3);
		list.head.next = new Node(6);
		list.head.next.next = new Node(9);
		list.head.next.next.next = new Node(15);
		list.head.next.next.next.next = new Node(30);

		// creating second linked list
		MyLinkedList list2 = new MyLinkedList();
		list2.head = new Node(10);
		list2.head.next = new Node(15);
		list2.head.next.next = new Node(30);

		System.out.println("Intersection point is " + getIntersectionNode(list.head, list2.head));
		System.out.println("The node of intersection is " + getNode(list.head, list2.head));

	}


	private static int getNode(Node head1, Node head2) {
		int c1 = getCount(head1);
		int c2 = getCount(head2);
		if (c1 > c2) {
			return getIntesectionNode(c1 - c2, head1, head2);
		} else {
			return getIntesectionNode(c2 - c1, head2, head1);
		}
	}

	
	private static int getCount(Node node) {
		Node current = node;
		int count = 0;

		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	private static int getIntesectionNode(int d, Node node1, Node node2) {

		Node current1 = node1;
		Node current2 = node2;
		for (int i = 0; i < d; i++) {
			if (current1 == null) {
				return -1;
			}
			current1 = current1.next;
		}
		while (current1 != null && current2 != null) {
			if (current1.data == current2.data) {
				return (int) current1.data;
			}
			current1 = current1.next;
			current2 = current2.next;
		}

		return -1;
	}
	
	
	
	//2nd Way
	private static Node getIntersectionNode(Node headA, Node headB) {
		Node current1 = headA, current2 = headB;
		while (current1 != current2) {
			current1 = (current1 != null) ? current1.next : headB;
			current2 = (current2 != null) ? current2.next : headA;
		}
		return current1;
	}
}
