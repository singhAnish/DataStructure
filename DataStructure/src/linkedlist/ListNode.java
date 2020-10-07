package linkedlist;


public class ListNode <T extends Comparable<?>>{
	public ListNode<T>  next;
	public T value;

	public ListNode(T value) {
		this.value = value;
		next = null;
	}
}

