package linkedlist;

public class LL_Length_of_Loop {

	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<Integer>(1);
		head.next = new ListNode<Integer>(2);
		ListNode<Integer> node = head.next.next = new ListNode<Integer>(3);
		head.next.next.next = new ListNode<Integer>(4);
		head.next.next.next.next = new ListNode<Integer>(5);
		head.next.next.next.next.next = node;

		System.out.println("Length of loop: " + lengthOfLoop(head));
	}

	private static int lengthOfLoop(ListNode<Integer> head) {
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
