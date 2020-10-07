package linkedlist;

// Time complexity : O(m+n)
// Space complexity : O(1)
public class LL_Intersection_Point {

	public static void main(String[] args) {		
		BaseLinkedList baseLinkedList = new BaseLinkedList();
		ListNode<Integer> head1 = baseLinkedList.createLinkedList();
		ListNode<Integer> head2 = baseLinkedList.createLinkedList();

		System.out.println("Intersection point is :  \t" + getNode(head1, head2));
	}


	private static int getNode(ListNode<Integer> head1, ListNode<Integer> head2) {
		int c1 = getCount(head1);
		int c2 = getCount(head2);
		if (c1 > c2) {
			return getIntesectionNode(c1 - c2, head1, head2);
		} else {
			return getIntesectionNode(c2 - c1, head2, head1);
		}
	}

	
	private static int getCount(ListNode<Integer> node) {
		ListNode<Integer> current = node;
		int count = 0;

		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	private static int getIntesectionNode(int d, ListNode<Integer> node1, ListNode<Integer> node2) {

		ListNode<Integer> current1 = node1;
		ListNode<Integer> current2 = node2;
		for (int i = 0; i < d; i++) {
			if (current1 == null) {
				return -1;
			}
			current1 = current1.next;
		}
		while (current1 != null && current2 != null) {
			if (current1.value == current2.value) {
				return (int) current1.value;
			}
			current1 = current1.next;
			current2 = current2.next;
		}

		return -1;
	}
	
	
	
	//2nd Way
	/*private static ListNode<Integer> getIntersectionNode(ListNode<Integer> headA, ListNode<Integer> headB) {
		ListNode<Integer> current1 = headA, current2 = headB;
		while (current1 != current2) {
			current1 = (current1 != null) ? current1.next : headB;
			current2 = (current2 != null) ? current2.next : headA;
		}
		return current1;
	}*/
}
