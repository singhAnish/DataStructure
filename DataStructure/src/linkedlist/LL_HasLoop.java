package linkedlist;

public class LL_HasLoop {

	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<Integer>(1);
		head.next = new ListNode<Integer>(2);
		ListNode<Integer> node = head.next.next = new ListNode<Integer>(3);
		head.next.next.next = new ListNode<Integer>(4);
		head.next.next.next.next = new ListNode<Integer>(5);
		head.next.next.next.next.next = node;

		System.out.println("Has Loop? " + hasLoop(head));

	}

	private static boolean hasLoop(ListNode<Integer> head) {
		ListNode<Integer> slow = head;
		ListNode<Integer> fast = head;

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
